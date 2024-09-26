package Restaturant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class restaurantDAO {
	public List<restaurant> getAllUsers() {
		List<restaurant> list=new ArrayList<>();
		       String str="SELECT * FROM foodweb.restaurant;";
			   try{
		      Connection con=DbConnection.getConnection();
			  Statement st=con.createStatement();
			  ResultSet r=st.executeQuery(str);
			  while(r.next()){
				  restaurant ip=new restaurant(r.getInt("restaurant_id"),r.getString("restaurant_name"),r.getString("location"),r.getString("cuisine_type"),r.getString("contact_info"),r.getFloat("rating"));
				   list.add(ip);
			  }
			   }
			   catch(Exception e){
                               e.printStackTrace();
			   }
			   return list;
}
}
