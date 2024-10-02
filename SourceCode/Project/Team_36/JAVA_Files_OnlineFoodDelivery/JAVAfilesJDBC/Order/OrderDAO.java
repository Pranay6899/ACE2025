package Order;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class OrderDAO {
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try {
            // Establishing a connection to the database
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();

            // Executing the query to retrieve  records from the Order table
            ResultSet rs = stm.executeQuery("SELECT * FROM foodweb.order");

            // Iterating through the ResultSet to create Order objects
            while (rs.next()) {
                Order order = new Order(
                    rs.getLong("order_id"),           // Fetch order_id
                    rs.getLong("customer_id"),        // Fetch customer_id
                    rs.getLong("restaurant_id"),      // Fetch restaurant_id
                    rs.getString("delivery_address"), // Fetch delivery_address
                    rs.getDouble("total_price"),      // Fetch total_price
                    rs.getString("status")            // Fetch status
                );

                // Adding the Order object to the list
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handling any exceptions that occur during the database operation
        }

        return orderList; // Returning the list of Order objects
    }
}
