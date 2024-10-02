package rating;

public class Rating {
    private int ratingID;
    private int orderID;
    private String rating;
    private String review;

    // Constructor
    public Rating(int ratingID, int orderID, String rating, String review) {
        this.ratingID = ratingID;
        this.orderID = orderID;
        this.rating = rating;
        this.review = review;
    }

    // Getters
    public int getRatingID() {
        return ratingID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    // Setters
    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    // Display method
    public void display() {
        System.out.println("Rating Details:");
        System.out.println("Rating ID: " + ratingID);
        System.out.println("Order ID: " + orderID);
        System.out.println("Rating: " + rating);
        System.out.println("Review: " + review);
        System.out.println();
    }
}
