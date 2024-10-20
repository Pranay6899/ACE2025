package Menu;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class MenuDAO {
    public List<MENU> getAllMenus() {
        List<MENU> menuList = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM Menu");

            while (rs.next()) {
                MENU menu = new MENU(rs.getInt("restaurant_id"),rs.getString("name"),rs.getString("description"),rs.getDouble("price"));

           
                menuList.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return menuList;
    }
}
