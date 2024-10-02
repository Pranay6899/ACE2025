package promotion;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Promotion> pr=new ArrayList<>();
		 System.out.format("%-5s %-15s %-20s %s\n","PromotionID","PromotionDetails","StartDate","EndDate");
		 PromotionDAO dao=new PromotionDAO();
		 pr=dao.getAllPromotions();
		 for(Promotion p:pr) {
			 System.out.format("%-5s %-15s %-20s %s\n",p.getPromotionId(),p.getPromotionDetails(),p.getStartDate(),p.getEndDate());
		 }
	}

}
