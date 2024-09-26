package fooddelivery;

public class Restaurant {
    
            private int id;
		    private String name;
		    private String location;
		    private String cusine;
		    private String contact;
		    private float rating;

			public restaurant(int id,String name,String location,String cusine,String contact,float rating){
				this.id=id;
				this.name=name;
				this.location=location;
				this.cusine=cusine;
				this.contact=contact;
				this.rating=rating;
				
			}
			public restaurant() {}
			public int getId() {
				return id;
			}
			public String getName() {
				return name;
			}
			public String getLocation() {
				return location;
			}
			public String getContact() {
				return contact;
	}
			public String getCusine() {
				return cusine;
			}
			public float getRating() {
				return rating;
			}
    public void display() {
        System.out.println("Restaurant Details:");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getLocation());
        System.out.println("Contact"+getContact());
        System.out.println("Cusine"+getCusine());
        System.out.println("Rating"+getRating());
        System.out.println();
    }
}

