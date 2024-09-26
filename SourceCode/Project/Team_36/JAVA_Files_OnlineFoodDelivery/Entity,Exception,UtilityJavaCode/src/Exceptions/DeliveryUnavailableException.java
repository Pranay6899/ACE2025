package Exceptions;

public class DeliveryUnavailableException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public DeliveryUnavailableException(String location) {
        super("Delivery is unavailable in location: " + location);
    }
}
