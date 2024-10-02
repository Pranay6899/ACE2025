package Menu;

import java.util.HashMap;

import java.util.Map;
import Exceptions.MenuItemNotFoundException;
import Exceptions.MenuItemUnavailableException;


public class MenuUtility {

    private Map<Long, MENU> menuDatabase = new HashMap<>();
    public MenuUtility() {
        // You can initialize with predefined menus if needed
    }

    public MENU addMenuItem(MENU menu) {
        menuDatabase.put(menu.getRestaurantId(), menu);
        return menu;
    }

    public MENU getMenuItem(Long restaurantId) throws MenuItemNotFoundException {
        MENU menu = menuDatabase.get(restaurantId);
        if (menu == null) {
            throw new MenuItemNotFoundException(restaurantId);
        }
        return menu;
    }



    public MENU updateMenuItem(Long restaurantId, MENU updatedMenu) throws MenuItemNotFoundException{
        if (!menuDatabase.containsKey(restaurantId)) {
            throw new MenuItemNotFoundException(restaurantId);
        }
        menuDatabase.put(restaurantId, updatedMenu);
        return updatedMenu;
    }

    public void deleteMenuItem(Long restaurantId) throws MenuItemNotFoundException {
        if (!menuDatabase.containsKey(restaurantId)) {
            throw new MenuItemNotFoundException(restaurantId);
        }
        menuDatabase.remove(restaurantId);
    }

    public void checkMenuItemAvailability(Long restaurantId) throws MenuItemUnavailableException{
        MENU menu = menuDatabase.get(restaurantId);
        if (menu == null || menu.getPrice() <= 0) {
            throw new MenuItemUnavailableException("Menu item is unavailable for restaurant ID: " + restaurantId);
        }
    }

    public Map<Long, MENU> getAllMenuItems() {
        return new HashMap<>(menuDatabase);
    }
}
