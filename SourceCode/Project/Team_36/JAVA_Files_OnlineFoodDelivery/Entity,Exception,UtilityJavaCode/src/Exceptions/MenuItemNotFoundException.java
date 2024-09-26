package Exceptions;

public class MenuItemNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public MenuItemNotFoundException(String itemName) {
        super("Menu item " + itemName + " not found.");
    }
}
