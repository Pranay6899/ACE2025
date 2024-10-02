package Main;
import Customer.*;
import Exceptions.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
	    Scanner s=new Scanner(System.in);
		
	     CustomerUtility r1=new CustomerUtility();
	     /*DeliveryUtilty r2=new DeliveryUtilty();
	     DriverUtility r3=new DriverUtility();
	     MenuUtility r4=new MenuUtility();
	     PaymentUtility r5=new PaymentUtility();
	     OrderUtility r6=new OrderUtility();
	     RestaurantUtility r7=new RestaurantUtility();*/
	     while (true) {
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
	                	}catch (CustomerNotFoundException e) {
	                        System.out.println(e.getMessage());
	                    }
	                	break;
	                case 6:
	                    System.out.println("Exiting the system.");
	                    s.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	     
	}
