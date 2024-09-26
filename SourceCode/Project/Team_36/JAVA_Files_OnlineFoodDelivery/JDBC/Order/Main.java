package Order;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        System.out.format("%-5s %-10s %-15s %-30s %-10s %-10s\n", "ID","Customer_ID","Restaurant_ID","Delivery Address","Total Price","Status");
        OrderDAO dao = new OrderDAO();
        orderList = dao.getAllOrders();
        //orders retrieved->database
        for (Order order : orderList) {
            System.out.format("%-5s %-10s %-15s %-30s %-10s %-10s\n", 
                order.getOrderId(), 
                order.getCustomerId(), 
                order.getRestaurantId(), 
                order.getDeliveryAddress(), 
                order.getTotalPrice(), 
                order.getStatus()
            );
        }
    }
}
