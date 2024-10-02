package Menu;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<MENU> menuList = new ArrayList<>();
        System.out.format("%-5s %-15s %-15s %-25s %10s\n", "ID", "Restaurant ID", "Name", "Description", "Price");
        MenuDAO dao = new MenuDAO(); // Assuming MenuDAO class exists to fetch data
        menuList = dao.getAllMenus();

        for (MENU menu : menuList) {
            System.out.format("%-5s %-15s %-15s %-25s %10s\n", 
                menu.getMenuId(), 
                menu.getRestaurantId(), 
                menu.getName(), 
                menu.getDescription(), 
                menu.getPrice());
        }
    }
}
