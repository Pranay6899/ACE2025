package UtilityClass;

import java.util.HashMap;
import java.util.Map;

import EntityClass.Menu;
import Exceptions.MenuItemNotFoundException;
import Exceptions.MenuItemUnavailableException;

public class MenuUtility {

    private Map<Long, Menu> menuDatabase = new HashMap<>();
    public MenuUtility() {
        // You can initialize with predefined menus if needed
    }

    public Menu addMenuItem(Menu menu) {
        menuDatabase.put(menu.getRestaurantId(), menu);
        return menu;
    }

    public Menu getMenuItem(Long restaurantId) {
        Menu menu = menuDatabase.get(restaurantId);
        if (menu == null) {
            throw new MenuItemNotFoundException("Menu item not found for restaurant ID: " + restaurantId);
        }
        return menu;
    }


    public Menu updateMenuItem(Long restaurantId, Menu updatedMenu) {
        if (!menuDatabase.containsKey(restaurantId)) {
            throw new MenuItemNotFoundException("Menu item with restaurant ID " +restaurantId()+ " not found.");
        }
        menuDatabase.put(restaurantId, updatedMenu);
        return updatedMenu;
    }

    public void deleteMenuItem(Long restaurantId) {
        if (!menuDatabase.containsKey(restaurantId)) {
            throw new MenuItemNotFoundException("Menu item not found for restaurant ID: " + restaurantId);
        }
        menuDatabase.remove(restaurantId);
    }

    public void checkMenuItemAvailability(Long restaurantId) {
        Menu menu = menuDatabase.get(restaurantId);
        if (menu == null || menu.getPrice() <= 0) {
            throw new MenuItemUnavailableException("Menu item is unavailable for restaurant ID: " + restaurantId);
        }
    }

    public Map<Long, Menu> getAllMenuItems() {
        return new HashMap<>(menuDatabase);
    }
}
