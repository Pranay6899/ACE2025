
package Customer;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<customer> al = new ArrayList<>();
        System.out.format("%-5s %-15s %-15s %-15s\n", "ID", "Name", "address", "phone");
        System.out.println("---------------------------------------------------");
        customerDAO dao = new customerDAO();
        al = dao.getAllUsers();

        for (customer u : al) {
            System.out.format("%-5s %-15s %-15s %-15s\n", u.getId(), u.getName(), u.getAddress(), u.getPhone());
        }
    }
}

