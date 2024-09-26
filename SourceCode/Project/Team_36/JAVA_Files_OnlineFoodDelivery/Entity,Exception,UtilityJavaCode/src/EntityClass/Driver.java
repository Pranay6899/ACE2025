package EntityClass;

public class Driver {
    private int driverId;
    private String name;
    private String phoneNumber;
    private String vehicleType;

    public Driver(int driverId, String name, String phoneNumber, String vehicleType) {
        this.driverId = driverId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}