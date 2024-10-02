package Driver;
import USER.user;
public class Driver extends user{

    private String phoneNumber;
    private String vehicleType;

    public Driver(int driverId, String name, String phoneNumber, String vehicleType) {
        super(driverId,name);
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public int getDriverId() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}