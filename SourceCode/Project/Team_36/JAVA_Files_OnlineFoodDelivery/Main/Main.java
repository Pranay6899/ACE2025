package Main;

import Customer.*;
import Delivery.*;
import Driver.*;
import Menu.*;
import payment.*;
import promotion.*;
import Order.*;
import rating.*;
import DashBoard.*;
import Exceptions.*;
import Restaurant.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CustomerUtility r1 = new CustomerUtility();
        DeliveryUtility r2 = new DeliveryUtility();
        DriverUtility r3 = new DriverUtility();
        MenuUtility r4 = new MenuUtility();
        PaymentUtility r5 = new PaymentUtility();
        OrderUtility r6 = new OrderUtility();
        PromotionUtility r7 = new PromotionUtility();
        RestaurantUtility r8 = new RestaurantUtility();
        RatingUtility r9 = new RatingUtility();
        
        boolean c = true;
        
        while (c) {
            System.out.println("Enter:\n1.Customer\n2.Delivery\n3.Driver\n4.Menu\n5.Order\n6.Payment\n7.Promotion\n8.Rating\n9.Restaurant\n10.Exit");
            int entityChoice = s.nextInt();

            switch (entityChoice) {
                case 1:
                    CustomerOperations(s,r1);
                    break;
                case 2:
                    DeliveryOperations(s,r2);
                    break;
                case 3:
                    DriverOperations(s,r3);
                    break;
                case 4:
                    MenuOperations(s,r4);
                    break;
                case 5:
                    OrderOperations(s,r6);
                    break;
                case 6:
                    PaymentOperations(s,r5);
                    break;
                case 7:
                    PromotionOperations(s, r7);
                    break;
                case 8:
                    RatingOperations(s, r9);
                    break;
                case 9:
                    RestaurantOperations(s, r8);
                    break;
                case 10:
                    System.out.println("Exiting the system.");
                    c = false;
                    s.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void CustomerOperations(Scanner s, CustomerUtility r1) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add customer");
            System.out.println("2. Delete customer");
            System.out.println("3. Update customer");
            System.out.println("4. Display customer details");
            System.out.println("5. Search Customer");
            System.out.println("6. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r1.createCustomer();
                    break;
                case 2:
                    r1.deleteCustomer();
                    break;
                case 3:
                    r1.updateCustomer();
                    break;
                case 4:
                    r1.displayCustomer();
                    break;
                case 5:
                    try {
                        r1.readCustomer();
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Exiting the customer operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void DeliveryOperations(Scanner s, DeliveryUtility r2) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add delivery");
            System.out.println("2. Delete delivery");
            System.out.println("3. Update delivery");
            System.out.println("4. Display delivery details");
            System.out.println("5. Check if driver delayed");
            System.out.println("6. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r2.createDelivery();
                    break;
                case 2:
                    r2.deleteDelivery();
                    break;
                case 3:
                    r2.updateDeliveryStatus();;
                    break;
                case 4:
                    r2.displayAllDeliveries();
                    break;
                case 5:
                	try {
                	r2.checkIfDelayed();
                	}catch(DeliveryDelayedException | DeliveryUnavailableException e) {
                		System.out.println(e.getMessage());
                	}
                	break;
                case 6:
                    System.out.println("Exiting the delivery operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void DriverOperations(Scanner s, DriverUtility r3) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add driver");
            System.out.println("2. Delete driver");
            System.out.println("3. Update driver");
            System.out.println("4. Display driver details");
            System.out.println("5.Check for driver availability");
            System.out.println("6. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r3.createDriver();
                    break;
                case 2:
                    r3.deleteDriver();
                    break;
                case 3:
                    r3.updateDriverPhoneNumber();
                    break;
                case 4:
                    r3.displayAllDrivers();
                    break;
                case 5:
                	try {
                	r3.checkDriverAvailability();
                	}
                	catch(DriverNotFoundException | DriverUnavailableException e) {
                		e.getMessage();
                		}
                	
                	break;
                case 6:
                    System.out.println("Exiting the driver operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void MenuOperations(Scanner s, MenuUtility r4) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            // Implement choices and logic for Menu
            System.out.println("1. Add menu item");
            System.out.println("2. Delete menu item");
            System.out.println("3. Update menu item");
            System.out.println("4. Display menu item details");
            System.out.println("5. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    //r4.createMenuItem();
                    break;
                case 2:
                    //r4.deleteMenuItem();
                    break;
                case 3:
                    // r4.updateMenuItem();
                    break;
                case 4:
                    // r4.displayMenuItem();
                    break;
                case 5:
                    System.out.println("Exiting the menu operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void OrderOperations(Scanner s, OrderUtility r6) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Place order");
            System.out.println("2. Cancel order");
            System.out.println("3. Update order status");
            System.out.println("4. Display order details");
            System.out.println("5. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r6.createOrder();
                    break;
                case 2:
                    r6.deleteOrder();
                    break;
                case 3:
                    r6.updateOrderStatus();
                    break;
                case 4:
                    r6.displayOrders();
                    break;
                case 5:
                    System.out.println("Exiting the order operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void PaymentOperations(Scanner s, PaymentUtility r5) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Process payment");
            System.out.println("2. Refund payment");
            System.out.println("3. Display payment details");
            System.out.println("4. Reading payment:");
            System.out.println("5. Update payment detail:");
            System.out.println("6. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r5.createPayment();
                    break;
                case 2:
                    r5.deletePayment();
                    break;
                case 3:
                    r5.displayPayments();
                    break;
                case 4:
                	r5.readPayment();
                	break;
                case 5:
                	r5.updatePayment();
                case 6:
                    System.out.println("Exiting the payment operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void PromotionOperations(Scanner s, PromotionUtility r7) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add promotion");
            System.out.println("2. Delete promotion");
            System.out.println("3. fetch promotion");
            System.out.println("4. Display promotion details");
            System.out.println("5. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r7.addNewPromotion();
                    break;
                case 2:
                    r7.removePromotion();
                    break;
                case 3:
                    r7.fetchPromotionById();
                    break;
                case 4:
                    r7.fetchAllPromotions();
                    break;
                case 5:
                    System.out.println("Exiting the promotion operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void RatingOperations(Scanner s, RatingUtility r9) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add rating");
            System.out.println("2. Update rating");
            System.out.println("3. Display rating details");
            System.out.println("4. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                   /* r9.addRating();
                    break;
                case 2:
                    r9.updateRating();
                    break;
                case 3:
                    r9.displayRating();
                    break;*/
                case 4:
                    System.out.println("Exiting the rating operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void RestaurantOperations(Scanner s, RestaurantUtility r8) {
        boolean ch = true;
        while (ch) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add restaurant");
            System.out.println("2. Delete restaurant");
            System.out.println("3. Update restaurant");
            System.out.println("4. Display restaurant details");
            System.out.println("5. Exit");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    r8.addRestaurant();
                    break;
                /*case 2:
                    r8.deleteRestaurant();
                    break;
                case 3:
                    r8.updateRestaurant();
                    break;
                case 4:
                    r8.displayRestaurant();
                    break;*/
                case 5:
                    System.out.println("Exiting the restaurant operations.");
                    ch = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    }

        
