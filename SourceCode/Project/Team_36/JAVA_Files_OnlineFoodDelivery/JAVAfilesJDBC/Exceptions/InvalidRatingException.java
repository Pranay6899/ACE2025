package Exceptions;

public class InvalidRatingException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public InvalidRatingException(int rating) {
        super("Rating " + rating + " is invalid. Must be between 1 and 5.");
    }
}
