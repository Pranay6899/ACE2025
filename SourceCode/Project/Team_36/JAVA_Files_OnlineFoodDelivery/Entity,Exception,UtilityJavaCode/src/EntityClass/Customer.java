package EntityClass;

public class Customer {
	private int customerId;
	private String name;
	private String address;
	private String phoneNumber;


	public Customer(int customerId,String name,String address,String phoneNumber) {
		// TODO Auto-generated constructor stub
		this.customerId=customerId;
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
