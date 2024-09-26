package rating;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class RatingDAO {
		public List<Rating> getAllRatings(){
		List<Rating> rl=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("Select * from rating");
			while(rs.next()) {
				Rating rt=new Rating(rs.getInt("rating_id"),rs.getInt("order_id"),rs.getString("stars"),rs.getString("comment"));
					rl.add(rt);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rl;
		

}
}
