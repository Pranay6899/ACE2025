package UtilityClass;
import Exceptions.OrderNotFoundException;
import Exceptions.InvalidOrderStateException;
import java.util.*;

import EntityClass.Order;
public class OrderUtility {

	    // Method to simulate finding an order by its ID
	    public static Order findOrderById(int orderId, List<Order> orders) throws OrderNotFoundException {
	        for (Order order : orders) {
	            if (order.getOrderId() == orderId) {
	                return order;
	            }
	        }
	        throw new OrderNotFoundException(orderId);
	    }

	    // Method to validate an order
	    public static void validateOrder(Order order) throws InvalidOrderStateException {
	        if (order.getTotalPrice() <= 0) {
	            throw new InvalidOrderStateException("Invalid order: total price must be greater than 0.");
	        }
	        if (order.getDeliveryAddress() == null || order.getDeliveryAddress().isEmpty()) {
	            throw new InvalidOrderStateException("Invalid order: delivery address cannot be empty.");
	        }
	        if (order.getStatus() == null || order.getStatus().isEmpty()) {
	            throw new InvalidOrderStateException("Invalid order: status cannot be empty.");
	        }
	    }
}
