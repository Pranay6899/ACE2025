package Exceptions;

public class RestaurantNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public RestaurantNotFoundException(String name) {
        super("Restaurant with ID " + name + " not found.");
    }
}