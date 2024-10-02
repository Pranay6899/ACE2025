package Restaurant;
import Exceptions.RestaurantNotFoundException;

import Exceptions.RestaurantClosedException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantUtility {

    public static List<Restaurant> restaurantList = new ArrayList<>();
    public static void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
        System.out.println("Restaurant " + restaurant.getRestaurantName() + " added successfully.");
    }
 
    public static void displayAllRestaurants() throws RestaurantClosedException {
        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants available.");
        } else {
            for (Restaurant restaurant : restaurantList) {
                displayRestaurantDetails(restaurant);
            }
        }
    }

    public static Restaurant findRestaurantById(int id) throws RestaurantNotFoundException {
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getRestaurantId() == id) {
                return restaurant;
            }
        }
        throw new RestaurantNotFoundException(id);
    }

    public static void displayRestaurantDetails(Restaurant restaurant) {
        System.out.println("Restaurant ID: " + restaurant.getRestaurantId());
        System.out.println("Restaurant Name: " + restaurant.getRestaurantName());
        System.out.println("Location: " + restaurant.getLocation());
        System.out.println("Cuisine: " + restaurant.getCusine());
        System.out.println("Contact: " + restaurant.getContact());
        System.out.println("Rating: " + restaurant.getRating());
    }
}
