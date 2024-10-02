package Exceptions;

public class DriverNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public DriverNotFoundException(int driverId) {
        super("Driver with ID " + driverId + " not found.");
    }
}

