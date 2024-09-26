package Exceptions;

public class DeliveryDelayedException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public DeliveryDelayedException(int id) {
        super("Delivery id with " + id + " is delayed");
    }
}
