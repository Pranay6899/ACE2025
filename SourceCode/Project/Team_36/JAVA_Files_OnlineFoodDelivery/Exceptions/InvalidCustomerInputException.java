package Exceptions;

public class InvalidCustomerInputException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public InvalidCustomerInputException(String message) {
        super(message);
    }
}
