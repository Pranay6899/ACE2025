package Restaurant;

	public class Restaurant {
		// TODO Auto-generated constructor stub
			private int restaurantId;
		    private String restaurantName;
		    private String location;
		    private String cusine;
		    private String contact;
		    private float rating;

			public Restaurant(int id,String name,String location,String cusine,String contact,float rating){
				this.restaurantId=id;
				this.restaurantName=name;
				this.location=location;
				this.cusine=cusine;
				this.contact=contact;
				this.rating=rating;
				
			}
			public Restaurant() {}
			public int getRestaurantId() {
				return restaurantId;
			}
			public String getRestaurantName() {
				return restaurantName;
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

}
