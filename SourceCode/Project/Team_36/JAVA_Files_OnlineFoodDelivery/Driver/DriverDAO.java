package Driver;

import DbConnection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
	public List<Driver> getAllDrivers() {
        List<Driver> List = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM foodweb.driver");

            while (rs.next()) {
                Driver driver = new Driver(rs.getInt("driver_id"), rs.getString("name"),rs.getString("phone_number"),rs.getString("vehicle_type"));
                List.add(driver);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return List;
    }
	  // Insert a new driver into the database
    public boolean insertIntoDriver(Driver driver) {
        String query = "INSERT INTO driver (driver_id, name, phone_number, vehicle_type) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, driver.getDriverId());
            ps.setString(2, driver.getName());
            ps.setString(3, driver.getPhoneNumber());
            ps.setString(4, driver.getVehicleType());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete a driver by their ID
    public void deleteFromDriver(int driverId) {
        String query = "DELETE FROM driver WHERE driver_id = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, driverId);
            ps.executeUpdate();
            System.out.println("Driver with ID " + driverId + " has been deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a driver's phone number
    public void updateDriverPhoneNumber(int driverId, String phoneNumber) {
        String query = "UPDATE driver SET phone_number = ? WHERE driver_id = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, phoneNumber);
            ps.setInt(2, driverId);
            ps.executeUpdate();
            System.out.println("Driver with ID " + driverId + " has been updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a specific driver by their ID
    public Driver getDriverById(int driverId) {
        String query = "SELECT * FROM driver WHERE driver_id = ?";
        Driver driver = null;

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, driverId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                driver = new Driver(rs.getInt("driver_id"), 
                                    rs.getString("name"), 
                                    rs.getString("phone_number"), 
                                    rs.getString("vehicle_type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}
