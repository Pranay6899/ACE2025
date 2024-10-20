package Exceptions;

public class MenuItemNotFoundException extends OnlineFoodDeliveryException {
	private static final long serialVersionUID = 2L;
    public MenuItemNotFoundException(Long id) {
        super("Menu item " + id+ " not found.");
    }
}
