package Exceptions;

public class OrderNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public OrderNotFoundException(int orderId) {
        super("Order with ID " + orderId + " not found.");
    }
}