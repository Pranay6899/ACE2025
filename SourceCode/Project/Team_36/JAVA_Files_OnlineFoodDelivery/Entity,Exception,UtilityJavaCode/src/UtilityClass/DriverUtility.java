package UtilityClass;

import Exceptions.DriverNotFoundException;
import Exceptions.DriverUnavailableException;
import java.util.*;

import EntityClass.Driver;

public class DriverUtility {
    private Map<Integer, Driver> driverMap = new HashMap<>();

    // Create a new driver
    public void createDriver(Driver driver) throws DriverUnavailableException {
        if (driver == null || driver.getDriverId() <= 0 || driver.getName() == null || driver.getName().isEmpty()) {
            throw new DriverUnavailableException(driver.getDriverId());
        }
        driverMap.put(driver.getDriverId(), driver);
    }

    // Read a driver by ID
    public Driver readDriver(int driverId) throws DriverNotFoundException {
        Driver driver = driverMap.get(driverId);
        if (driver == null) {
            throw new DriverNotFoundException(driverId);
        }
        return driver;
    }

    // Update an existing driver
    public void updateDriver(Driver driver) throws DriverNotFoundException, DriverUnavailableException {
        if (driver == null || driver.getDriverId() <= 0 || driver.getName() == null || driver.getName().isEmpty()) {
            throw new DriverUnavailableException(driver.getDriverId());
        }
        if (!driverMap.containsKey(driver.getDriverId())) {
            throw new DriverNotFoundException(driver.getDriverId() );
        }
        driverMap.put(driver.getDriverId(), driver);
    }

    // Delete a driver by ID
    public void deleteDriver(int driverId) throws DriverNotFoundException {
        if (!driverMap.containsKey(driverId)) {
            throw new DriverNotFoundException(driverId);
        }
        driverMap.remove(driverId);
    }
}
