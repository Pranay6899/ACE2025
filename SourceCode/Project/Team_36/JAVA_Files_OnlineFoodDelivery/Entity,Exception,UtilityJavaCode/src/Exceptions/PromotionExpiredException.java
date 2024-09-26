package Exceptions;

public class PromotionExpiredException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public PromotionExpiredException(String promoCode) {
        super("Promotion with code " + promoCode + " has expired.");
    }
}
