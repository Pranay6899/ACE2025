package UtilityClass;

import java.util.HashMap;
import java.util.Map;

import EntityClass.Customer;
import Exceptions.CustomerNotFoundException;
import Exceptions.InvalidCustomerInputException;

public class CustomerUtility {
    private Map<Integer, Customer> customerMap = new HashMap<>();

    // Create a new customer
    public void createCustomer(Customer customer) throws InvalidCustomerInputException {
        if (customer == null || customer.getCustomerId() <= 0 || customer.getName() == null || customer.getName().isEmpty()) {
            throw new InvalidCustomerInputException("Invalid customer input.");
        }
        customerMap.put(customer.getCustomerId(), customer);
    }

    // Read a customer by ID
    public Customer readCustomer(int customerId) throws CustomerNotFoundException {
        Customer customer = customerMap.get(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException(customerId);
        }
        return customer;
    }

    // Update an existing customer
    public void updateCustomer(Customer customer) throws CustomerNotFoundException, InvalidCustomerInputException {
        if (customer == null || customer.getCustomerId() <= 0 || customer.getName() == null || customer.getName().isEmpty()) {
            throw new InvalidCustomerInputException("Invalid customer input.");
        }
        if (!customerMap.containsKey(customer.getCustomerId())) {
            throw new CustomerNotFoundException(customer.getCustomerId());
        }
        customerMap.put(customer.getCustomerId(), customer);
    }

    // Delete a customer by ID
    public void deleteCustomer(int customerId) throws CustomerNotFoundException {
        if (!customerMap.containsKey(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }
        customerMap.remove(customerId);
    }
}