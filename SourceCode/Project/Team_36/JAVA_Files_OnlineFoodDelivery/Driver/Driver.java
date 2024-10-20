package Driver;

public class Driver{
	private int id;
	private String name;
    private String phoneNumber;
    private String vehicleType;

    public Driver(int driverId, String name, String phoneNumber, String vehicleType) {
        this.id=driverId;
        this.name=name;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public int getDriverId() {
        return getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
    public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}