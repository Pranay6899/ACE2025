package rating;
import Exceptions.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class RatingUtility {
	private RatingDAO ratingDAO;

    public RatingUtility() {
        this.ratingDAO = new RatingDAO();
    }

    // Fetch all ratings
    public List<Rating> fetchAllRatings() {
        try {
            return ratingDAO.getAllRatings();
        } catch (Exception e) {
            System.out.println("Error fetching ratings: " + e.getMessage());
            return null;
        }
    }

    // Add a new rating
    public boolean addNewRating() {
        try {
        	Scanner s=new Scanner(System.in);
        	System.out.println("Enter the rating id:");
        	int id=s.nextInt();
        	System.out.println("Enter the order id:");
        	int orderId=s.nextInt();
        	s.nextLine();
        	System.out.println("Enter the rating");
        	String rating=s.nextLine();
        	System.out.println("Enter the review");
        	String review=s.nextLine();
        	Rating r=new Rating(id,orderId,rating,review);
            validateRating();
            return ratingDAO.insertRating(r);
        } catch (InvalidRatingException e) {
            System.out.println("Invalid rating: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error adding rating: " + e.getMessage());
            return false;
        }
    }

    // Update an existing rating
    public boolean updateExistingRating(Rating rating) {
        try {
            validateRating();
            return ratingDAO.updateRating(rating);
        } catch (InvalidRatingException e) {
            System.out.println("Invalid rating: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error updating rating: " + e.getMessage());
            return false;
        }
    }

    // Delete a rating
    public void removeRating() {
    	Scanner s=new Scanner(System.in);
    	int ratingID=s.nextInt();
    	RatingDAO ratingDAO=new RatingDAO();
        ratingDAO.deleteRating(ratingID);
    }

    // Validate the rating value
    private void validateRating() throws InvalidRatingException {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter the rating id:");
    	int id=s.nextInt();
    	System.out.println("Enter the order id:");
    	int orderId=s.nextInt();
    	s.nextLine();
    	System.out.println("Enter the rating");
    	String rating=s.nextLine();
    	System.out.println("Enter the review");
    	String review=s.nextLine();
    	Rating r =new Rating(id,orderId,rating,review);
        int rateValue = Integer.parseInt(r.getRating());
        if (rateValue < 1 || rateValue > 5) {
            throw new InvalidRatingException(rateValue);
        }
    }
   

}
