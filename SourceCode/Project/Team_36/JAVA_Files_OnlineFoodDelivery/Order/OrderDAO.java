package Order;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Exceptions.*;

public class OrderDAO {

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM foodweb.order");

            while (rs.next()) {
                Order order = new Order(
                    rs.getLong("order_id"), 
                    rs.getLong("customer_id"), 
                    rs.getLong("restaurant_id"), 
                    rs.getString("delivery_address"), 
                    rs.getDouble("total_price"), 
                    rs.getString("status")
                );
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList; 
    }

    // Retrieve an order by ID
    public Order getOrderById(Long orderId) throws OrderNotFoundException {
        String query = "SELECT * FROM order WHERE order_id = ?";
        Order order = null;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order = new Order(
                    rs.getLong("order_id"), 
                    rs.getLong("customer_id"), 
                    rs.getLong("restaurant_id"), 
                    rs.getString("delivery_address"), 
                    rs.getDouble("total_price"), 
                    rs.getString("status")
                );
            } else {
                throw new OrderNotFoundException(orderId.intValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    // Insert a new order into the database
    public boolean insertOrder(Order order) throws InvalidOrderStateException {
        String query = "INSERT INTO order (order_id, customer_id, restaurant_id, delivery_address, total_price, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, order.getOrderId());
            ps.setLong(2, order.getCustomerId());
            ps.setLong(3, order.getRestaurantId());
            ps.setString(4, order.getDeliveryAddress());
            ps.setDouble(5, order.getTotalPrice());
            ps.setString(6, order.getStatus());

            int result = ps.executeUpdate(); // Execute the insert operation
            if (result > 0) {
                return true; // If insertion is successful
            } else {
                throw new InvalidOrderStateException("Failed to insert order.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an order's status
    public boolean updateOrderStatus(Long orderId, String status) throws InvalidOrderStateException, OrderNotFoundException {
        String query = "UPDATE order SET status = ? WHERE order_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, status);
            ps.setLong(2, orderId);

            int result = ps.executeUpdate(); // Execute the update operation
            if (result > 0) {
                return true; // If update is successful
            } else {
                throw new InvalidOrderStateException("Unable to update order status.");
            }
        } catch (Exception e) {
            throw new OrderNotFoundException(orderId.intValue());
        }
    }

    // Delete an order from the database
    public void deleteOrder(Long orderId) throws OrderNotFoundException {

        String query = "DELETE FROM order WHERE order_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            
            int result = ps.executeUpdate(); // Execute the delete operation

            if (result == 0) {
                throw new OrderNotFoundException(orderId.intValue()); // If no rows were deleted
            } else {
                System.out.println("Order with ID " + orderId + " deleted successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
