package Customer;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;
import Exceptions.CustomerNotFoundException;
import Exceptions.InvalidCustomerInputException;


public class CustomerUtility{
    private static List<Customer> customerList=new ArrayList<>();

    // Create a new customer
    public void createCustomer() {
       
        Scanner s=new Scanner(System.in);
        try {
        	int id=idGeneration();
        System.out.println("generated id is: "+id);
        System.out.println("Enter the new customer name:");
        String name=s.nextLine();
        System.out.println("Enter the address of customer:");
        String address=s.nextLine();
        System.out.println("Enter the Phone Number of customer:");
        String phone=s.nextLine();
        Customer customer=new Customer(id,name,address,phone);
        customerList.add(customer);
        CustomerDAO dao=new CustomerDAO();
        dao.insertIntoCustomer(customer);
        }
        catch(Exception e) {
        	System.err.println("error"+e.getMessage());
        }
    }
    private int idGeneration() {
        Set<Integer> set = new HashSet<>();
        for (Customer customer : customerList) {
            set.add(customer.getId());
        }
        Random rand = new Random();
        int id = rand.nextInt(10, 100);
        while (set.contains(id)) {
            id = rand.nextInt(10, 100);
        }
        return id;
    }

    // Read a customer by ID
    public void readCustomer() throws CustomerNotFoundException{
        Scanner s = new Scanner(System.in);
        CustomerDAO dao=new CustomerDAO();
        customerList=dao.getAllCustomers();
        System.out.println("Enter the name, address, or phone number of the customer to search for:");
        String str = s.nextLine();
        List<Customer> matchingCustomers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (str.equalsIgnoreCase(customer.getName()) || str.equalsIgnoreCase(customer.getAddress()) || str.equals(customer.getPhoneNumber())) {
                matchingCustomers.add(customer);
            }
        }
        if (matchingCustomers.isEmpty()) {
            throw new CustomerNotFoundException(str);
        } else {
            System.out.format("%-5s %-15s %-10s %s\n", "ID", "Name", "Address", "Phone Number");
            for (Customer c : matchingCustomers) {
                System.out.format("%-5s %-15s %-10s %s\n", c.getId(), c.getName(), c.getAddress(), c.getPhoneNumber());
            }
        }
    }

    // Update an existing customer
    public void updateCustomer(){
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Customer Id");
            int customerId = s.nextInt();
            s.nextLine();
            System.out.println("Enter New phone Number");
            String phoneNumber = s.nextLine();
            String phoneRegex = "^\\+?[0-9]{1,3}?[\\s-]?[0-9]{10}$";
            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(phoneNumber);
            if (!matcher.matches()) {
                throw new InvalidCustomerInputException("Invalid phone number format");
            }
            boolean customerFound = false;
            for (Customer customer : customerList) {
                if (customer.getId() == customerId) {
                    customerFound = true;
                    break;
                }
            }
            if (!customerFound) {
                throw new CustomerNotFoundException(customerId);
            } else {
                CustomerDAO dao1 = new CustomerDAO();
                dao1.updateCustomer(customerId,phoneNumber);
                System.out.println("Phone number updated successfully.");
            }
        } catch (Exception e) {
            System.err.println(e);
        } 
    }


    // Delete a customer by ID
    public void deleteCustomer(){
        Scanner s = new Scanner(System.in);  
        try {
            System.out.println("Enter Customer ID to delete:");
            int customerId = s.nextInt();
            boolean customerFound = false;
    
            for (Customer customer : customerList) {
                if (customer.getId() == customerId) {
                    customerFound = true;
                    break;
                }
            }
            if (!customerFound) {
                throw new CustomerNotFoundException(customerId);
            } else {
                CustomerDAO dao = new CustomerDAO();
                dao.deleteFromCustomer(customerId);
            }
        }
        catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //display values
    public void displayCustomer() {
    	CustomerDAO dao=new CustomerDAO();
        customerList=dao.getAllCustomers();
        System.out.format("%-5s %-15s %-10s %s\n","ID","Name","address","phoneNumber");
        for(Customer c:customerList) {
        	System.out.format("%-5s %-15s %-10s %s\n",c.getId(),c.getName(),c.getAddress(),c.getPhoneNumber());        }
    
}
}