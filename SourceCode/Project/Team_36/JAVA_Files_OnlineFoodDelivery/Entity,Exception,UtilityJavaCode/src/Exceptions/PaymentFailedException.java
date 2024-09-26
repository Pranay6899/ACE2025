package Exceptions;


public class PaymentFailedException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public PaymentFailedException(String paymentMethod) {
        super("Payment failed using method: " + paymentMethod);
    }
}
