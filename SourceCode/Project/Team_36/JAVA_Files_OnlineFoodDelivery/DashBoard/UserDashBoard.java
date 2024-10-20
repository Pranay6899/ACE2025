package DashBoard;
import java.util.Scanner;
import Item.*;
import java.util.ArrayList;
import java.util.List;

public class UserDashBoard {
    private static List<String> cart;
    public UserDashBoard() {
    	cart = new ArrayList<>();
    }
    
    public void display() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the choice");
        int activity, orderChoice;
        String itemName = "";
        do {
            System.out.println("1.Order Food\n2.My Orders\n3.Exit");
            activity = s.nextInt();
            s.nextLine();
            if (activity == 1) {
                do {
                    System.out.println("1.Search Food By name\n2.Filter Veg or Non-veg\n3.Search Food By Restaurant\n4.Order\n5.Exit");
                    orderChoice = s.nextInt();
                    s.nextLine();
                    switch (orderChoice) {
                        case 1:
                            System.out.println("Enter Food name");
                            itemName = s.nextLine();
                            itemUtility item = new itemUtility();
                            if (item.readCustomer(itemName)) {
                                System.out.println("Item is " + itemName);
                                System.out.println("Do you want add to cart: type yes or no");
                                String str = s.nextLine();
                                if (str.equalsIgnoreCase("yes")) {
                                    cart.add(itemName);
                                    System.out.println("Successfully added");
                                } else {
                                    break;
                                }
                            } else {
                                System.out.println("Item not available");
                            }
                            break;
                            
                         case 2:
                            default:
                            System.out.println("Enter a valid choice");
                    }
                    System.out.println("Do you want another food: Type: Yes or No");
                    itemName = s.nextLine();
                } while (itemName.equalsIgnoreCase("Yes"));
            } 
            
            else if (activity == 2) {
                System.out.println("Your orders:");
                for (String item : cart) {
                    System.out.println(item);
                }
            }
        } while (activity != 3);
    }
}

