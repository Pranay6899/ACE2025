package Menu;
public class MENU {
    Long menuId;
    Long restaurantId;
    String name;
    String description;
    Double price;
    MENU(Long restaurantId, String name, String description, Double price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getMenuId() {
        return menuId;
    }

    public Long getRestaurantId() {
        return restaurantId;
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
