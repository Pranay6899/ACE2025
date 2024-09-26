package Menu;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class MenuDAO {
    public List<MENU> getAllMenus() {
        List<MENU> menuList = new ArrayList<>();
        try {
            // Establishing a connection to the database
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();

            // Executing the query to retrieve all records from the Menu table
            ResultSet rs = stm.executeQuery("SELECT * FROM Menu");

            // Iterating through the ResultSet to create MENU objects
            while (rs.next()) {
                MENU menu = new MENU(
                    rs.getLong("restaurant_id"),    // Fetching restaurant_id
                    rs.getString("name"),           // Fetching name
                    rs.getString("description"),    // Fetching description
                    rs.getDouble("price")           // Fetching price
                );

                // Adding the MENU object to the list
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handling any exceptions that occur during the database operation
        }

        return menuList; // Returning the list of MENU objects
    }
}
