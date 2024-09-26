package payment;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class PaymentDAO {
	public List<Payment> getAllPayments(){
	List<Payment> pym=new ArrayList<>();
	try {
		Connection con=DbConnection.getConnection();
		Statement  stm=con.createStatement();
		ResultSet rs=stm.executeQuery("Select * from payment");
		while(rs.next()) {
			Payment pm= new Payment(rs.getInt("payment_id"),rs.getInt("order_id"),rs.getDouble("amount"),rs.getString("payment_method"));
			pym.add(pm);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return pym; 
}
}
