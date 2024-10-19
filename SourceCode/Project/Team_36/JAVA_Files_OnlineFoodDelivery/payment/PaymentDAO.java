package payment;
import DbConnection.DbConnection;
import Exceptions.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // Retrieve all payments from the database
    public List<Payment> getAllPayments() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM foodweb.Payment");
            while (rs.next()) {
                Payment payment = new Payment(rs.getInt("payment_id"), rs.getInt("order_id"), rs.getDouble("amount"), rs.getString("payment_method"));
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentList;
    }

    // Insert a new payment into the database
    public boolean insertPayment(Payment payment) throws PaymentFailedException {
        String query = "INSERT INTO foodweb.Payment(payment_id, order_id, amount, payment_method) VALUES (?, ?, ?, ?)";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, payment.getPayment_id());
            ps.setInt(2, payment.getOrder_id());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPayment_method());

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                throw new PaymentFailedException(payment.getPayment_method());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update payment details
    public boolean updatePayment(int paymentId, double amount) throws PaymentFailedException {
        String query = "UPDATE Payment SET amount = ? WHERE payment_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, amount);
            ps.setInt(2, paymentId);

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                throw new PaymentFailedException("Unknown payment method");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a payment from the database
    public void deletePayment(int paymentId) {
        String query = "DELETE FROM Payment WHERE payment_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, paymentId);
            ps.executeUpdate();
            System.out.println("Payment with ID " + paymentId + " has been deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a payment by ID
    public Payment getPaymentById(int paymentId) {
        String query = "SELECT * FROM Payment WHERE payment_id = ?";
        Payment payment = null;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, paymentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                payment = new Payment(rs.getInt("payment_id"), rs.getInt("order_id"), rs.getDouble("amount"), rs.getString("payment_method"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }
}

