package Driver;

import DbConnection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DriverDAO {
	public List<Driver> getAllDriver() {
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
}
