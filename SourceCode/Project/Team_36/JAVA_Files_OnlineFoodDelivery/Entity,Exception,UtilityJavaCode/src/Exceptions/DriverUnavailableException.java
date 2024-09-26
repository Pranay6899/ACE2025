package Exceptions;

public class DriverUnavailableException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public DriverUnavailableException(int driverId) {
        super("Driver with ID " + driverId + " is currently unavailable.");
    }
}
