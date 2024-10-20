package Menu;
import Restaurant.*;
public class MENU extends Restaurant {
    private String name;
    private String description;
    private Double price;
    MENU(int restaurantId,String name, String description, Double price) {
    	
        this.name = name;
        this.description = description;
        this.price = price;
    }
   
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
