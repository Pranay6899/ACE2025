package UtilityClass;

import java.util.HashMap;
import java.util.Map;

import EntityClass.Delivery;
import Exceptions.DeliveryDelayedException;
import Exceptions.DeliveryUnavailableException;
public class DeliveryUtilty {
    private Map<Integer, Delivery> deliveryMap = new HashMap<>();

    // Create a new delivery
    public void createDelivery(Delivery delivery) {
        deliveryMap.put(delivery.getDeliveryId(), delivery);
    }

    // Read a delivery by ID
    public Delivery readDelivery(int deliveryId) throws DeliveryUnavailableException {
        Delivery delivery = deliveryMap.get(deliveryId);
        if (delivery == null) {
            throw new DeliveryUnavailableException("Delivery with ID " + deliveryId + " is unavailable.");
        }
        return delivery;
    }

    // Update an existing delivery
    public void updateDelivery(Delivery delivery) throws DeliveryUnavailableException {
        if (!deliveryMap.containsKey(delivery.getDeliveryId())) {
            throw new DeliveryUnavailableException("Delivery with ID " + delivery.getDeliveryId() + " is unavailable.");
        }
        deliveryMap.put(delivery.getDeliveryId(), delivery);
    }

    // Delete a delivery by ID
    public void deleteDelivery(int deliveryId) throws DeliveryUnavailableException {
        if (!deliveryMap.containsKey(deliveryId)) {
            throw new DeliveryUnavailableException("Delivery with ID " + deliveryId + " is unavailable.");
        }
        deliveryMap.remove(deliveryId);
    }

    // Check if a delivery is delayed
    public void checkIfDelayed(int deliveryId) throws DeliveryDelayedException, DeliveryUnavailableException {
        Delivery delivery = readDelivery(deliveryId);
        if ("Delayed".equalsIgnoreCase(delivery.getDeliveryStatus())) {
            throw new DeliveryDelayedException(deliveryId);
        }
    }
}
