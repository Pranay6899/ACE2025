package Exceptions;

public class RestaurantNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public RestaurantNotFoundException(int restaurantId) {
        super("Restaurant with ID " + restaurantId + " not found.");
    }
}