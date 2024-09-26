package Exceptions;

public class RestaurantClosedException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public RestaurantClosedException(String restaurantName) {
        super("Restaurant " + restaurantName + " is currently closed.");
    }
}
