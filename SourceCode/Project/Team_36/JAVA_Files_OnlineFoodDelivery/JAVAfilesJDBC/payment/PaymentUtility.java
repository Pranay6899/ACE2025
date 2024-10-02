package payment;

import Exceptions.InsufficientFundsException;
import Exceptions.PaymentFailedException;
public class PaymentUtility {
   
    public static void processPayment(Payment payment, double availableFunds) throws PaymentFailedException, InsufficientFundsException {
        
        if (payment.getAmount() > availableFunds) {
            throw new InsufficientFundsException("Insuffiecient funds");
        }    
        if (payment.getPayment_method() == null || payment.getPayment_method().isEmpty()) {
            throw new PaymentFailedException("Payment failed: Payment method not specified.");
        }
      
        System.out.println("Payment processed successfully for Order ID: " + payment.getOrder_id());
    }
}