package Exceptions;

public class InsufficientFundsException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public InsufficientFundsException(String mssg) {
        super(mssg);
    }
}
