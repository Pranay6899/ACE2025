package Item;

import java.util.ArrayList;
import java.util.List;

public class itemUtility {
	private static List<Item> itemList=new ArrayList<>();
	public boolean readCustomer(String itemName){
        itemDAO dao=new itemDAO();
        itemList=dao.getAllItems();
        for (Item item : itemList){
            if(item.getItem().equalsIgnoreCase(itemName)) {
            	return true;
            }
        }
        return false;
    }

}
