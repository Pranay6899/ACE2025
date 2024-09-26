package fooddelivery;

import java.util.Date;

public class Order {
    Long orderId;
    Long customerId;
    Long restaurantId;
    String deliveryAddress;
    Double totalPrice;
    String status;

    // Constructor
    public Order(Long orderId, Long customerId, Long restaurantId, String deliveryAddress, Double totalPrice, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.deliveryAddress = deliveryAddress;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    // Getter methods
    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }
}
