package payment;

import Exceptions.InsufficientFundsException;
import java.util.Scanner;
import java.util.Set;

import Customer.Customer;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

import Exceptions.PaymentFailedException;
public class PaymentUtility {
	private static List<Payment> paymentList = new ArrayList<>();

	// Create a new payment
    public void createPayment() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Generated new Payment ID:");
            int paymentId =idGeneration() ;
            System.out.println("Enter Order ID:");
            int orderId = s.nextInt();
            s.nextLine();
            System.out.println("Enter Payment Amount:");
            double amount = s.nextDouble();
            s.nextLine();
            System.out.println("Enter Payment Method (e.g., Card, Cash, etc.):");
            String paymentMethod = s.nextLine();

            if (amount <= 0) {
                throw new InsufficientFundsException("Amount must be greater than 0.");
            }

            Payment payment = new Payment(paymentId, orderId, amount, paymentMethod);
            paymentList.add(payment);

            PaymentDAO dao = new PaymentDAO();
            dao.insertPayment(payment);
            System.out.println("Payment created successfully.");
        } catch (InsufficientFundsException | PaymentFailedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private int idGeneration() {
        Set<Integer> set = new HashSet<>();
        for (Payment payment : paymentList) {
            set.add(payment.getPayment_id());
        }
        Random rand = new Random();
        int id = rand.nextInt(1000,2000);
        while (set.contains(id)) {
            id = rand.nextInt(1000,2000);
        }
        return id;
    }


    // Read all payments
    public void displayPayments() {
        PaymentDAO dao = new PaymentDAO();
        paymentList = dao.getAllPayments();
        System.out.format("%-10s %-10s %-10s %s\n", "Payment ID", "Order ID", "Amount", "Payment Method");
        for (Payment p : paymentList) {
            System.out.format("%-10d %-10d %-10.2f %s\n", p.getPayment_id(), p.getOrder_id(), p.getAmount(), p.getPayment_method());
        }
    }

    // Search for a payment by ID
    public void readPayment() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Payment ID:");
            int paymentId = s.nextInt();

            PaymentDAO dao = new PaymentDAO();
            Payment payment = dao.getPaymentById(paymentId);
            if (payment == null) {
                throw new PaymentFailedException("Unknown");
            } else {
                System.out.format("Payment ID: %d, Order ID: %d, Amount: %.2f, Payment Method: %s\n", payment.getPayment_id(), payment.getOrder_id(), payment.getAmount(), payment.getPayment_method());
            }
        } catch (PaymentFailedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Update a payment
    public void updatePayment() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Payment ID:");
            int paymentId = s.nextInt();
            System.out.println("Enter New Amount:");
            double amount = s.nextDouble();
            if (amount <= 0) {
                throw new InsufficientFundsException("Amount must be greater than 0.");
            }

            PaymentDAO dao = new PaymentDAO();
            if (dao.updatePayment(paymentId, amount)) {
                System.out.println("Payment updated successfully.");
            } else {
                throw new PaymentFailedException("Unknown");
            }
        } catch (InsufficientFundsException | PaymentFailedException e) {
            System.err.println("Error:" + e.getMessage());
        }
    }

    // Delete a payment
    public void deletePayment() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Payment ID to delete:");
            int paymentId = s.nextInt();

            PaymentDAO dao = new PaymentDAO();
            dao.deletePayment(paymentId);
            System.out.println("Payment deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}