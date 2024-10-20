package Customer;

public class Customer{
	private int customerId;
	private String customerName;
    private String phoneNumber;
    private String address;

	public Customer(int customerId,String customerName,String address,String phone){
		this.customerId=customerId;
		this.customerName=customerName;
		this.phoneNumber=phone;
		this.address=address;
	}

	public int getCustomerId() {
		return getCustomerId();
	}
	public String getCustomerName() {
		return getCustomerName();
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	}
