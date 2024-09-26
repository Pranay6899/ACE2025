package EntityClass;

public class Delivery {
    private int deliveryId;   // Unique ID for the delivery
    private int orderId;      // ID of the associated order
    private int driverId;     // ID of the driver assigned to the delivery
    private String deliveryStatus; // Status of the delivery (e.g., "Pending", "In Progress", "Delivered", "Delayed")

    // Constructor
    public Delivery(int deliveryId, int orderId, int driverId, String deliveryStatus) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.driverId = driverId;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters and Setters
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
