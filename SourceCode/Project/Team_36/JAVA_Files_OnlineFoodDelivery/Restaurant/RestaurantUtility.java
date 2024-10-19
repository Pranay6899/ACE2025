package Restaurant;

import Exceptions.RestaurantNotFoundException;

import Exceptions.RestaurantClosedException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;


public class RestaurantUtility {

    public static List<Restaurant> restaurantList = new ArrayList<>();
    
    public void addRestaurant() {
    Scanner s=new Scanner(System.in);
    try {
    	int id=idGeneration();
    System.out.println("generated id is: "+id);
    System.out.println("Enter the restaurant name:");
    String name=s.nextLine();
    System.out.println("Enter the location of restaurant:");
    String address=s.nextLine();
    System.out.println("Enter the cusine_type of restaurant:");
    String phone=s.nextLine();
    System.out.println("Enter the contact of restaurant:");
    String contact=s.nextLine();
    System.out.println("Rating of restaurant:");
    float rating=s.nextFloat();
    System.out.println("Give it open or close");
    boolean openOrclose=s.nextBoolean();
    Restaurant restaurant=new Restaurant(id,name,address,phone,contact,rating,openOrclose);
    restaurantList.add(restaurant);
    restaurantDAO dao=new restaurantDAO();
    dao.insertIntoRestaurant(restaurant);
    }
    catch(Exception e) {
    	System.err.println("error"+e.getMessage());
    }
}
private int idGeneration() {
    Set<Integer> set = new HashSet<>();
    for (Restaurant r : restaurantList) {
        set.add(r.getRestaurantId());
    }
    Random rand = new Random();
    int id = rand.nextInt(500, 600);
    while (set.contains(id)) {
        id = rand.nextInt(500, 600);
    }
    return id;
}
 
public void displayRestaurantDetails() {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the id");
	try {
	int restaurantId=s.nextInt();
    for (Restaurant restaurant : restaurantList) {
        if (restaurant.getRestaurantId() == restaurantId) {
            if (!restaurant.getIsOpen()) {
                throw new RestaurantClosedException(restaurant.getRestaurantName());
            }
            System.out.format("Restaurant ID: %d\n", restaurant.getRestaurantId());
            System.out.format("Name: %s\n", restaurant.getRestaurantName());
            System.out.format("Location: %s\n", restaurant.getLocation());
            System.out.format("Cuisine: %s\n", restaurant.getCusine());
            System.out.format("Contact: %s\n", restaurant.getContact());
            System.out.format("Rating: %.1f\n", restaurant.getRating());
            System.out.format("IsOpen: %s\n",restaurant.getIsOpen());
            return;
        }
    }
	}catch(Exception e) {e.getMessage();}
    System.out.println("Restaurant not found.");
}

    public Restaurant findRestaurantByName() throws RestaurantNotFoundException {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the name of the restaurant: ");
        String name = s.nextLine();
        for (Restaurant restaurant : restaurantList) {
            if (restaurant.getRestaurantName().equalsIgnoreCase(name)) {
                return restaurant;
            }
        }
        throw new RestaurantNotFoundException(name);
    }
}
