package Exceptions;

public class InvalidOrderStateException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public InvalidOrderStateException(String message) {
        super("Invalid order state: " + message);
    }
}
