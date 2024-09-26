package payment;

import java.util.*;

public class Main {
	public static void main(String[] args)  {
		List<Payment> py=new ArrayList<>();
		System.out.format("%-5s %-15s %-10s %s\n","PaymentID","OrderID","Amount","PaymentMethod");
		PaymentDAO dao=new PaymentDAO();
		py=dao.getAllPayments();
		for(Payment p:py){
		    System.out.format("%-5s %-15s %-10s %s\n",p.getPayment_id(),p.getOrder_id(),p.getAmount(),p.getPayment_method());
		}
	}
}
