package Delivery;
import DbConnection.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
	public List<Delivery> getAllDeliveries() {
        List<Delivery> deliveryList = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM foodweb.delivery");

            while (rs.next()) {
                Delivery delivery = new Delivery(rs.getInt("delivery_id"), rs.getInt("order_id"),rs.getInt("driver_id"),rs.getString("delivery_status"));
                deliveryList.add(delivery);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return deliveryList;
    }

    public boolean insertIntoDelivery(Delivery delivery) {
        String query = "INSERT INTO delivery (delivery_id, order_id, driver_id, delivery_status) VALUES (?, ?, ?, ?)";
        try {
        	Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, delivery.getDeliveryId());
            ps.setInt(2, delivery.getOrderId());
            ps.setInt(3, delivery.getDriverId());
            ps.setString(4, delivery.getDeliveryStatus());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteFromDelivery(int deliveryId) {
        String deleteQuery = "DELETE FROM delivery WHERE delivery_id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            ps.setInt(1, deliveryId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryStatus(int deliveryId, String status) {
        String updateQuery = "UPDATE delivery SET delivery_status = ? WHERE delivery_id = ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateQuery)) {

            ps.setString(1, status);
            ps.setInt(2, deliveryId);
            ps.executeUpdate();
            System.out.println("Delivery with ID " + deliveryId + " has been updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Delivery getDeliveryById(int deliveryId) {
        String query = "SELECT * FROM delivery WHERE delivery_id = ?";
        Delivery delivery = null;
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, deliveryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                delivery = new Delivery(rs.getInt("delivery_id"), 
                                        rs.getInt("order_id"), 
                                        rs.getInt("driver_id"), 
                                        rs.getString("delivery_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delivery;
    }
}
