package UtilityClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import EntityClass.Restaurant;

public class RestaurantUtility {

   
    private static List<Restaurant> restaurantList = new ArrayList<>();


    public static void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
        System.out.println("Restaurant " + restaurant.getRestaurantName() + " added successfully.");
    }

 
    public static void displayAllRestaurants() {
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
        throw new RestaurantNotFoundException(restaurant.getRestaurantId());
    }

    // Display restaurant details (helper method)
    public static void displayRestaurantDetails(Restaurant restaurant) {
        System.out.println("Restaurant ID: " + restaurant.getRestaurantId());
        System.out.println("Restaurant Name: " + restaurant.getRestaurantName());
        System.out.println("Location: " + restaurant.getLocation());
        System.out.println("Cuisine: " + restaurant.getCuisine());
        System.out.println("Contact: " + restaurant.getContact());
        System.out.println("Rating: " + restaurant.getRating());
    }
}
