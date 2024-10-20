package Delivery;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import Exceptions.DeliveryDelayedException;
import Exceptions.DeliveryUnavailableException;
public class DeliveryUtility {
	private static List<Delivery> deliveryList = new ArrayList<>();
	public void createDelivery() {
        Scanner s = new Scanner(System.in);
        try {
            int deliveryId = idGeneration();
            System.out.println("Generated Delivery ID: " + deliveryId);
            System.out.println("Enter Order ID:");
            int orderId = s.nextInt();
            System.out.println("Enter Driver ID:");
            int driverId = s.nextInt();
            s.nextLine(); // Consume newline
            System.out.println("Enter Delivery Status:");
            String status = s.nextLine();

            Delivery delivery = new Delivery(deliveryId, orderId, driverId, status);
            deliveryList.add(delivery);

            DeliveryDAO dao = new DeliveryDAO();
            dao.insertIntoDelivery(delivery);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private int idGeneration() {
        Set<Integer> set = new HashSet<>();
        for (Delivery delivery : deliveryList) {
            set.add(delivery.getDeliveryId());
        }
        Random rand = new Random();
        int id = rand.nextInt(10, 100);
        while (set.contains(id)) {
            id = rand.nextInt(10, 100);
        }
        return id;
    }

    public void readDelivery() {
        Scanner s = new Scanner(System.in);
        DeliveryDAO dao = new DeliveryDAO();
        deliveryList = dao.getAllDeliveries();
        System.out.println("Enter the delivery status to search for:");
        String status = s.nextLine();
        List<Delivery> matchingDeliveries = new ArrayList<>();

        for (Delivery delivery : deliveryList) {
            if (status.equalsIgnoreCase(delivery.getDeliveryStatus())) {
                matchingDeliveries.add(delivery);
            }
        }
        if (matchingDeliveries.isEmpty()) {
            System.out.println("No deliveries found with status: " + status);
        } else {
            System.out.format("%-5s %-10s %-10s %s\n", "ID", "Order ID", "Driver ID", "Status");
            for (Delivery d : matchingDeliveries) {
                System.out.format("%-5s %-10s %-10s %s\n", d.getDeliveryId(), d.getOrderId(), d.getDriverId(), d.getDeliveryStatus());
            }
        }
    }

    public void updateDeliveryStatus() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Delivery ID to update:");
            int deliveryId = s.nextInt();
            s.nextLine();
            System.out.println("Enter new Delivery Status:");
            String status = s.nextLine();

            DeliveryDAO dao = new DeliveryDAO();
            boolean deliveryFound = false;
            deliveryList = dao.getAllDeliveries();

            for (Delivery delivery : deliveryList) {
                if (delivery.getDeliveryId() == deliveryId) {
                    deliveryFound = true;
                    break;
                }
            }

            if (!deliveryFound) {
                System.out.println("Delivery ID " + deliveryId + " not found.");
            } else {
                dao.updateDeliveryStatus(deliveryId, status);
                System.out.println("Delivery status updated successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void deleteDelivery() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Delivery ID to delete:");
            int deliveryId = s.nextInt();

            DeliveryDAO dao = new DeliveryDAO();
            deliveryList = dao.getAllDeliveries();
            boolean deliveryFound = false;

            for (Delivery delivery : deliveryList) {
                if (delivery.getDeliveryId() == deliveryId) {
                    deliveryFound = true;
                    break;
                }
            }

            if (!deliveryFound) {
                System.out.println("Delivery ID " + deliveryId + " not found.");
            } else {
                dao.deleteFromDelivery(deliveryId);
                System.out.println("Delivery deleted successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    

    // Check if a delivery is delayed
    public void checkIfDelayed() throws DeliveryDelayedException, DeliveryUnavailableException {
    	Scanner s=new Scanner(System.in);
    	System.out.println("Enter the id of delivery you want check:");
    	int deliveryId=s.nextInt();
        DeliveryDAO dao = new DeliveryDAO();
        Delivery delivery = dao.getDeliveryById(deliveryId);
        if (delivery == null) {
            throw new DeliveryUnavailableException("Delivery with ID " + deliveryId + " is not available.");
        }
        if ("pending".equalsIgnoreCase(delivery.getDeliveryStatus())) {
            throw new DeliveryDelayedException(deliveryId);
        }
    }

    public void displayAllDeliveries() {
        DeliveryDAO dao = new DeliveryDAO();
        deliveryList = dao.getAllDeliveries();
        System.out.format("%-5s %-10s %-10s %s\n", "ID", "Order ID", "Driver ID", "Status");
        for (Delivery d : deliveryList) {
            System.out.format("%-5s %-10s %-10s %s\n", d.getDeliveryId(), d.getOrderId(), d.getDriverId(), d.getDeliveryStatus());
        }
    }
}
