package Delivery;
import DbConnection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
	public List<Delivery> getAllDelivery() {
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
}
