package Exceptions;
import java.io.Serializable;

public class OnlineFoodDeliveryException extends Exception implements Serializable {
    
    private static final long serialVersionUID = 1L;  // Add this line to suppress the warning

    public OnlineFoodDeliveryException(String message) {
        super(message);
    }
}


