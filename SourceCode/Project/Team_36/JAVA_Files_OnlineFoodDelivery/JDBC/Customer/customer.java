package Customer;
public class customer {
	private int id;
    private String name;
    private String phone;
    private String address;

	public customer(int id,String name,String address,String phone){
		this.id=id;
		this.name=name;
		this.phone=phone;
		this.address=address;
		
	}
	public customer() {}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	}
		// TODO Auto-generated constructor stu
