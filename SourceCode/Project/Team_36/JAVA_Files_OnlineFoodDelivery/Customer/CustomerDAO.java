package Customer;

import java.util.*;
import DbConnection.DbConnection;
import java.sql.*;

public class CustomerDAO {

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String query = "SELECT * FROM foodweb.customer";
        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customer_id"), 
                                                 rs.getString("customer_name"), 
                                                 rs.getString("address"), 
                                                 rs.getString("phone_number"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertIntoCustomer(Customer customer) {
        String query = "INSERT INTO customer (customer_id, customer_name, address, phone_number) VALUES (?, ?, ?, ?)";
        
        try {
        		Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query); 

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhoneNumber());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteFromCustomer(int customerId) {
    	String deleteDelivery="DELETE FROM foodweb.Delivery WHERE order_id=?";
    	 String deleteOrdersQuery = "DELETE FROM foodweb.order WHERE customer_id = ?";
        String deleteQuery = "DELETE FROM customer WHERE customer_id = ?";
        
        
        try {
        	Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteQuery);
             PreparedStatement psOrders = con.prepareStatement(deleteOrdersQuery);
             PreparedStatement psDelivery = con.prepareStatement(deleteDelivery);
 
             psOrders.setInt(1, customerId);
            psOrders.executeUpdate();
            
            ps.setInt(1, customerId);
            ps.executeUpdate();
                System.out.println("Customer with ID " + customerId + " has been deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int customerId, String phoneNumber) {

        String updateQuery = "UPDATE customer SET phone_number = ? WHERE customer_id = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateQuery)) {

            ps.setString(1, phoneNumber);
            ps.setInt(2, customerId);
            ps.executeUpdate();
                System.out.println("Customer with ID " + customerId + " has been updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Customer getCustomerById(int customerId) {
    	String updateQuery = "SELECT * from customer WHERE customer_id = ?";

    	Customer customer = null;
        try {
        	Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateQuery);
        	
            ps.setInt(1, customerId);
            
            ResultSet rs =  ps.executeQuery(updateQuery);
            if(rs.next()) {
                customer = new Customer(rs.getInt("customer_id"), 
                                                 rs.getString("customer_name"), 
                                                 rs.getString("address"), 
                                                 rs.getString("phone_number"));
            }
                System.out.println("Customer with ID " + customerId + " has been updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return customer;
    }
}
