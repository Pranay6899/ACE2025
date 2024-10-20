package Driver;

import Exceptions.DriverNotFoundException;


import Exceptions.DriverUnavailableException;
import java.util.*;

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DriverUtility {
    private static List<Driver> driverList = new ArrayList<>();

    // Create a new driver
    public void createDriver() {
        Scanner s = new Scanner(System.in);
        try {
            int driverId = idGeneration();
            System.out.println("Generated Driver ID: " + driverId);
            System.out.println("Enter Driver's Name:");
            String name = s.nextLine();
            System.out.println("Enter Driver's Phone Number:");
            String phone = s.nextLine();
            System.out.println("Enter Driver's Vehicle Type:");
            String vehicleType = s.nextLine();
            Driver driver = new Driver(driverId, name, phone, vehicleType);
            driverList.add(driver);
            DriverDAO dao = new DriverDAO();
            dao.insertIntoDriver(driver);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Generate unique ID for driver
    private int idGeneration() {
        Set<Integer> set = new HashSet<>();
        for (Driver driver : driverList) {
            set.add(driver.getDriverId());
        }
        Random rand = new Random();
        int id = rand.nextInt(10, 100);
        while (set.contains(id)) {
            id = rand.nextInt(10, 100);
        }
        return id;
    }

    // Read and search for a driver by name, phone, or vehicle type
    public void readDriver() throws DriverNotFoundException{
        Scanner s = new Scanner(System.in);
        DriverDAO dao = new DriverDAO();
        driverList = dao.getAllDrivers();
        System.out.println("Enter the name, phone number, or vehicle type of the driver to search for:");
        String str = s.nextLine();
        List<Driver> matchingDrivers = new ArrayList<>();

        for (Driver driver : driverList) {
            if (str.equalsIgnoreCase(driver.getName()) || str.equals(driver.getPhoneNumber()) || str.equalsIgnoreCase(driver.getVehicleType())) {
                matchingDrivers.add(driver);
            }
        }

        if (matchingDrivers.isEmpty()) {
            throw new DriverNotFoundException(-1);
        } else {
            System.out.format("%-5s %-15s %-15s %s\n", "ID", "Name", "Phone Number", "Vehicle Type");
            for (Driver d : matchingDrivers) {
                System.out.format("%-5s %-15s %-15s %s\n", d.getDriverId(), d.getName(), d.getPhoneNumber(), d.getVehicleType());
            }
        }
    }

    // Update a driver's phone number
    public void updateDriverPhoneNumber() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Driver ID:");
            int driverId = s.nextInt();
            s.nextLine();
            System.out.println("Enter new phone number:");
            String phoneNumber = s.nextLine();

            DriverDAO dao = new DriverDAO();
            boolean driverFound = false;
            driverList = dao.getAllDrivers();

            for (Driver driver : driverList) {
                if (driver.getDriverId() == driverId) {
                    driverFound = true;
                    break;
                }
            }

            if (!driverFound) {
                throw new DriverNotFoundException(driverId);
            } else {
                dao.updateDriverPhoneNumber(driverId, phoneNumber);
                System.out.println("Driver's phone number updated successfully.");
            }
        } catch (DriverNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Delete a driver by ID
    public void deleteDriver(){
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Driver ID to delete:");
            int driverId = s.nextInt();

            DriverDAO dao = new DriverDAO();
            driverList = dao.getAllDrivers();
            boolean driverFound = false;

            for (Driver driver : driverList) {
                if (driver.getDriverId() == driverId) {
                    driverFound = true;
                    break;
                }
            }

            if (!driverFound) {
                throw new DriverNotFoundException(driverId);
            } else {
                dao.deleteFromDriver(driverId);
                System.out.println("Driver deleted successfully.");
            }
        } catch (DriverNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }

    // Check if a driver is unavailable
    public void checkDriverAvailability() throws DriverNotFoundException,DriverUnavailableException {
    	Scanner s = new Scanner(System.in);
    	int driverId=s.nextInt();
        DriverDAO dao = new DriverDAO();
        Driver driver = dao.getDriverById(driverId);

        if (driver == null) {
            throw new DriverNotFoundException(driverId);
        }

        String availabilityStatus = "unavailable";
        if ("unavailable".equalsIgnoreCase(availabilityStatus)) {
            throw new DriverUnavailableException(driverId);
        } else {
            System.out.println("Driver with ID " + driverId + " is available.");
        }
    }

    // Display all drivers
    public void displayAllDrivers() {
        DriverDAO dao = new DriverDAO();
        driverList = dao.getAllDrivers();
        System.out.format("%-5s %-15s %-15s %s\n", "ID", "Name", "Phone Number", "Vehicle Type");
        for (Driver d : driverList) {
            System.out.format("%-5s %-15s %-15s %s\n", d.getDriverId(), d.getName(), d.getPhoneNumber(), d.getVehicleType());
        }
    }
}
