package promotion;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class PromotionDAO {
		public List<Promotion> getAllPromotions(){
			List<Promotion> pr=new ArrayList<>();
			try {
				Connection con=DbConnection.getConnection();
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery("Select * from Promotion");
				while(rs.next()) {
					Promotion prm=new Promotion(rs.getInt("promotion_id"),rs.getInt("restaurant_id"),rs.getString("promotion_details"),rs.getDate("start_date"),rs.getDate("end_date"));
					pr.add(prm);
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return pr;
			
		}
		
	
	
}
