package Exceptions;

public class PromotionNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public PromotionNotFoundException(String promoCode) {
        super("Promotion with code " + promoCode + " not found.");
    }
}
