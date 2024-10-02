package Customer;
import USER.user;
public class Customer extends user{
    private String phoneNumber;
    private String address;

	public Customer(int customerId,String customerName,String address,String phone){
		super(customerId,customerName);
		this.phoneNumber=phone;
		this.address=address;
	}

	public int getId() {
		return super.getId();
	}
	public String getName() {
		return super.getName();
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	}
