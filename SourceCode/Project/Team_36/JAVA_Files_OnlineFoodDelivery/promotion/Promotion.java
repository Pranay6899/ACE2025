package promotion;
import java.util.*;
public class Promotion{
	private int restaurantId;
	private int promotionId;
	private String promotionDetails;
	private Date startDate;
	private Date endDate;
	
	public Promotion(int promotionId,int restaurantId,String promotionDetails,Date startDate,Date endDate) {
		this.promotionId=promotionId;
		this.restaurantId=restaurantId;
		this.promotionDetails=promotionDetails;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId=promotionId;
	}
	public String getPromotionDetails(){
		return promotionDetails;
	}
	public void setPromotionDetails(String promotionDetails) {
		this.promotionDetails=promotionDetails;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate=startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate=endDate;
	}
}