package UtilityClass;
import EntityClass.Payment;
import Exceptions.InsufficientFundsException;
import Exceptions.PaymentFailedException;
public class PaymentUtility {
    // Method to simulate processing a payment
    public static void processPayment(Payment payment, double availableFunds) throws PaymentFailedException, InsufficientFundsException {
        // Check if payment amount exceeds available funds
        if (payment.getAmount() > availableFunds) {
            throw new InsufficientFundsException("Insuffiecient funds");
        }
        
        // Simulate payment processing logic
        if (payment.getPaymentMethod() == null || payment.getPaymentMethod().isEmpty()) {
            throw new PaymentFailedException("Payment failed: Payment method not specified.");
        }
        
        System.out.println("Payment processed successfully for Order ID: " + payment.getOrderId());
    }
}