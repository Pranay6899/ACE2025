package Restaurant;
import DbConnection.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class restaurantDAO {
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> list=new ArrayList<>();
		       String str="SELECT * FROM foodweb.restaurant;";
			   try{
		      Connection con=DbConnection.getConnection();
			  Statement st=con.createStatement();
			  ResultSet r=st.executeQuery(str);
			  while(r.next()){
				  Restaurant ip=new Restaurant(r.getInt("restaurant_id"),r.getString("restaurant_name"),r.getString("location"),r.getString("cuisine_type"),r.getString("contact_info"),r.getFloat("rating"),r.getBoolean("isOpen"));
				   list.add(ip);
			  }
			   }
			   catch(Exception e){
                               e.printStackTrace();
			   }
			   return list;
}
	public boolean insertIntoRestaurant(Restaurant restaurant) {
        String query = "INSERT INTO restaurant (restaurant_id, restaurant_name, location, cusine_type,contact_info,rating,isOpen) VALUES (?,?,?,?,?,?,?)";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, restaurant.getRestaurantId());
            ps.setString(2, restaurant.getRestaurantName());
            ps.setString(3, restaurant.getLocation());
            ps.setString(4, restaurant.getCusine());
            ps.setString(5, restaurant.getContact());
            ps.setFloat(6, restaurant.getRating());
            ps.setBoolean(7, restaurant.getIsOpen());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteFromRestaurant(int restaurantId) {
        String deleteQuery = "DELETE FROM restaurant WHERE restaurant_id = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            ps.setInt(1, restaurantId);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("restuarant with ID " + restaurantId + " has been deleted.");
            } else {
                System.out.println("No restuarant found with ID " + restaurantId + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRestaurant(int restaurantId,boolean isopen) {
        String updateQuery = "UPDATE customer SET isOpen = ? WHERE restaurant_id = ?";
        
        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(updateQuery)) {

            ps.setInt(1, restaurantId);
            ps.setBoolean(2,isopen);
            ps.executeUpdate();
                System.out.println("restuarant with ID " + restaurantId + " has been updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
