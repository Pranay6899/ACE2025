package Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DbConnection.DbConnection;

public class itemDAO {
	public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String query = "SELECT * FROM foodweb.item";
        try {
        	 Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Item item = new Item(rs.getString("itemName"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
