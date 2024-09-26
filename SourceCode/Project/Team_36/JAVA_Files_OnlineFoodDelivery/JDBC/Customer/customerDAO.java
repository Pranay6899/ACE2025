package Customer;

import java.util.*;
import java.sql.*;
public class customerDAO {
	public List<customer> getAllUsers() {
		List<customer> list=new ArrayList<customer>();
		       String str="SELECT * FROM foodweb.customer;";
			   try{
		      Connection con=DbConnection.getConnection();
			  Statement st=con.createStatement();
			  ResultSet r=st.executeQuery(str);
			  while(r.next()){
				  customer ip=new customer(r.getInt("customer_id"),r.getString("customer_name"),r.getString("address"),r.getString("phone_number"));
				   list.add(ip);
			  }
			   }
			   catch(Exception e){
                               e.printStackTrace();
			   }
			   return list;
}
}
