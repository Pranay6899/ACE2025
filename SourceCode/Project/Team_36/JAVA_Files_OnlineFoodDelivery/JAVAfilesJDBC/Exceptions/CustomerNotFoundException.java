
package Exceptions;

public class CustomerNotFoundException extends OnlineFoodDeliveryException {
    private static final long serialVersionUID = 2L;  
    
    public CustomerNotFoundException(int customerId) {
        super("Customer with ID " + customerId + " not found.");
    }
    public CustomerNotFoundException(String searchTerm) {
        super("Customer with the search term '" + searchTerm + "' not found.");
    }
}
