package fooddelivery;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
        
        // Creating an instance of the Restaurant class
        Restaurant restaurant1 = new Restaurant(1, "Burger King", "123 Main St", "New York", "NY", "10001");
        Restaurant restaurant2 = new Restaurant(2, "Pizza Hut", "456 Elm St", "Los Angeles", "CA", "90001");
        Restaurant restaurant3 = new Restaurant(3, "McDonald's", "789 Oak St", "Chicago", "IL", "60601");
        Restaurant restaurant4 = new Restaurant(4, "Subway", "321 Maple St", "Houston", "TX", "77001");
        Restaurant restaurant5 = new Restaurant(5, "Domino's", "901 Pine St", "Philadelphia", "PA", "19101");
        Restaurant restaurant6 = new Restaurant(6, "KFC", "234 Cedar Ave", "San Francisco", "CA", "94101");
        
        Restaurant[] r = {restaurant1, restaurant2, restaurant3, restaurant4, restaurant5, restaurant6};

        for (int i = 0; i < restaurants.length; i++) {
            r[i].display();
        }


        //create customer objects
        System.out.println("---------CUSTOMER PART-------");
        Customer customer1 = new Customer(1, "John", "Doe", "johndoe@example.com", "123-456-7890", "123 Main St", "New York", "NY", "10001");
        Customer customer2 = new Customer(2, "Jane", "Smith", "janesmith@example.com", "987-654-3210", "456 Elm St", "Los Angeles", "CA", "90001");
        Customer customer3 = new Customer(3, "Bob", "Johnson", "bobjohnson@example.com", "555-123-4567", "789 Oak St", "Chicago", "IL", "60601");
        Customer customer4 = new Customer(4, "Alice", "Williams", "alicewilliams@example.com", "321-987-6543", "321 Maple St", "Houston", "TX", "77001");
        Customer customer5 = new Customer(5, "Mike", "Davis", "mikedavis@example.com", "901-555-1234", "901 Pine St", "Philadelphia", "PA", "19101");

        Customer[] customers = {customer1, customer2, customer3, customer4, customer5};

        for (int i = 0; i < customers.length; i++) {
        	customers[i].display();
        }
        //create order objects
        System.out.print("---------ORDER PART-------\n");
        Order order1 = new Order(1, 1, 1, new Date(), 29.99);
        Order order2 = new Order(2, 2, 2, new Date(), 15.99);
        Order order3 = new Order(3, 3, 3, new Date(), 9.99);
        Order order4 = new Order(4, 4, 4, new Date(), 19.99);
        Order order5 = new Order(5, 5, 5, new Date(), 12.99);
        Order[] orders = {order1, order2, order3, order4, order5};
        for (int i = 0; i < orders.length; i++) {
            orders[i].display();
            //orders[i] is used to access the Order object at index i in the orders array.//
        }


        //create menu objects

            System.out.print("---------Menu PART-------\n");
            Menu menu1 = new Menu(1, 1, "Cheeseburger", 5.99);
            Menu menu2 = new Menu(2, 1, "Veggie Burger", 6.99);
            Menu menu3 = new Menu(3, 2, "Pepperoni Pizza", 8.99);
            Menu menu4 = new Menu(4, 2, "Cheese Pizza", 7.99);
            Menu menu5 = new Menu(5, 3, "Big Mac", 4.99);
            Menu menu6 = new Menu(6, 3, "McNuggets", 3.99);

            Menu[] menus = {menu1, menu2, menu3, menu4, menu5, menu6};

            for (int j = 0; j < menus.length; j++) {
                menus[j].display();
            }
                

              //create driver objects
                System.out.print("---------Driver PART-------\n");

                Driver driver1 = new Driver(1, "John", "Doe", "john.doe@example.com", "555-1234", "D12345678");
                Driver driver2 = new Driver(2, "Jane", "Smith", "jane.smith@example.com", "555-5678", "D87654321");
                Driver driver3 = new Driver(3, "Jim", "Brown", "jim.brown@example.com", "555-8765", "D45678901");
                Driver driver4 = new Driver(4, "Jake", "White", "jake.white@example.com", "555-4321", "D98765432");
                Driver driver5 = new Driver(5, "Jill", "Green", "jill.green@example.com", "555-6789", "D12340987");

                Driver[] drivers = {driver1, driver2, driver3, driver4, driver5};

                for (int k = 0; k < drivers.length; k++) {
                    drivers[k].display();
                }


                //create delivery objects
            System.out.print("---------Delivery PART-------\n");
            Delivery delivery1 = new Delivery(1, 1, 1, new Date(), "10:30 AM");
            Delivery delivery2 = new Delivery(2, 2, 2, new Date(), "11:00 AM");
            Delivery delivery3 = new Delivery(3, 3, 3, new Date(), "11:30 AM");
            Delivery delivery4 = new Delivery(4, 4, 4, new Date(), "12:00 PM");
            Delivery delivery5 = new Delivery(5, 5, 5, new Date(), "12:30 PM");

            // Storing Delivery instances in an array
            Delivery[] deliveries = {delivery1, delivery2, delivery3, delivery4, delivery5};

            for (int k = 0; k < deliveries.length; k++) {
                deliveries[k].display();
            }


            //create payment objects
            System.out.print("---------Payment PART-------\n");
            Payment payment1 = new Payment(1, 1, "Credit Card", new Date(), 29.99);
            Payment payment2 = new Payment(2, 2, "PayPal", new Date(), 19.99);
            Payment payment3 = new Payment(3, 3, "Cash", new Date(), 24.99);
            Payment payment4 = new Payment(4, 4, "Credit Card", new Date(), 34.99);
            Payment payment5 = new Payment(5, 5, "Debit Card", new Date(), 22.99);

            Payment[] payment = {payment1,payment2,payment3,payment4,payment5};

            for (int k = 0; k < payment.length; k++) {                
            	payment[k].display();  
            }


            //create rating objects
            Rating rating1 = new Rating(1, 1, "5 stars", "Great service!");
            Rating rating2 = new Rating(2, 2, "4 stars", "Good food, but late delivery");
            Rating rating3 = new Rating(3, 3, "3 stars", "Average experience");
            Rating rating4 = new Rating(4, 4, "5 stars", "Excellent food quality");
            Rating rating5 = new Rating(5, 5, "2 stars", "Poor customer service");

            // Displaying the details of each rating
            System.out.println("Rating Details:");
            rating1.display();
            rating2.display();
            rating3.display();
            rating4.display();
            rating5.display();
        }
	}
