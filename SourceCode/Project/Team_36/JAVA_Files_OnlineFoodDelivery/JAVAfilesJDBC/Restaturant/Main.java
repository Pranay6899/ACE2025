package Restaturant;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<restaurant> al = new ArrayList<>();
	        System.out.format("%-5s %-25s %-25s %-25s %-25s %-25s \n", "ID", "Name", "Location", "Cuisine-type","contact-info","rating");
	        restaurantDAO dao = new restaurantDAO();
	        al = dao.getAllUsers();

	        for (restaurant u : al) {
	            System.out.format("%-5s %-25s %-25s %-25s %-25s %25s \n", u.getId(), u.getName(), u.getLocation(), u.getCusine(),u.getContact(),u.getRating());
	        }
	}
}
