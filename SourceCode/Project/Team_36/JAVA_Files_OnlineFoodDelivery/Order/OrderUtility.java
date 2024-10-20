package Order;
import Exceptions.OrderNotFoundException;

import Exceptions.InvalidOrderStateException;
import java.util.*;

import Customer.Customer;

public class OrderUtility {
    private static List<Order> orderList = new ArrayList<>();

    // Create a new order
    public void createOrder() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Generated Order ID:");
            Long orderId = idGeneration();
            System.out.println("Enter Customer ID:");
            Long customerId = s.nextLong();
            System.out.println("Enter Restaurant ID:");
            Long restaurantId = s.nextLong();
            s.nextLine();
            System.out.println("Enter Delivery Address:");
            String deliveryAddress = s.nextLine();
            System.out.println("Enter Total Price:");
            Double totalPrice = s.nextDouble();
            s.nextLine();
            System.out.println("Enter Status (Pending, Delivered, etc.):");
            String status = s.nextLine();
            Order order = new Order(orderId, customerId, restaurantId, deliveryAddress, totalPrice, status);
            orderList.add(order);
            OrderDAO dao = new OrderDAO();
            dao.insertOrder(order);
            System.out.println("Order created successfully.");
        } catch (InvalidOrderStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private long idGeneration() {
        Set<Long> set = new HashSet<>();
        for (Order order : orderList) {
            set.add(order.getOrderId());
        }
        Random rand = new Random();
        long id = rand.nextLong(100000, 20000000);
        while (set.contains(id)) {
            id = rand.nextLong(100000, 20000000);
        }
        return id;
    }


    // Display all orders
    public void displayOrders() {
        OrderDAO dao = new OrderDAO();
        orderList = dao.getAllOrders();
        System.out.format("%-10s %-12s %-12s %-20s %-10s %s\n", "Order ID", "Customer ID", "Restaurant ID", "Delivery Address", "Total Price", "Status");
        for (Order o : orderList) {
            System.out.format("%-10d %-12d %-12d %-20s %-10.2f %s\n", o.getOrderId(), o.getCustomerId(), o.getRestaurantId(), o.getDeliveryAddress(), o.getTotalPrice(), o.getStatus());
        }
    }

    // Retrieve an order by ID
    public void readOrder() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Order ID:");
            Long orderId = s.nextLong();

            OrderDAO dao = new OrderDAO();
            Order order = dao.getOrderById(orderId);
            if (order == null) {
                throw new OrderNotFoundException(orderId.intValue());
            } else {
                System.out.format("Order ID: %d, Customer ID: %d, Restaurant ID: %d, Delivery Address: %s, Total Price: %.2f, Status: %s\n", 
                    order.getOrderId(), order.getCustomerId(), order.getRestaurantId(), order.getDeliveryAddress(), order.getTotalPrice(), order.getStatus());
            }
        } catch (OrderNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Update the status of an order
    public void updateOrderStatus() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Order ID:");
            Long orderId = s.nextLong();
            s.nextLine();
            System.out.println("Enter New Status (e.g., Delivered, Canceled, Processing):");
            String status = s.nextLine();

            OrderDAO dao = new OrderDAO();
            dao.updateOrderStatus(orderId, status);
            System.out.println("Order status updated successfully.");
        } catch (OrderNotFoundException | InvalidOrderStateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Delete an order
    public void deleteOrder() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Order ID to delete:");
            Long orderId = s.nextLong();
            OrderDAO dao = new OrderDAO();
            dao.deleteOrder(orderId);
            System.out.println("Order deleted successfully.");
        } catch (OrderNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
