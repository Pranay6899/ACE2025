package Exceptions;

public class MenuItemUnavailableException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public MenuItemUnavailableException(String itemName) {
        super("Menu item " + itemName + " is currently unavailable.");
    }
}
