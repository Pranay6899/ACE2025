package rating;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Rating> rl=new ArrayList<>();
		System.out.format("%-5s %-15s %-20s %s\n","RatingID","OrderID","Rating","Review");
		RatingDAO dao=new RatingDAO();
		rl=dao.getAllRatings();
		for(Rating r:rl) {
			System.out.format("%-5s %-15s %-20s %s\n",
					r.getRatingID(),
					r.getOrderID(),
					r.getRating(),
					r.getReview());
		}
		
	}

}
