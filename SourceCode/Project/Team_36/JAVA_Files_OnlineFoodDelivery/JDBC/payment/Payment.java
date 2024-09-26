package payment;


public class Payment {
    private int payment_id;
    private int order_id;
    private double amount;
    private String payment_method;

    // Constructor
    public Payment(int payment_id, int order_id,double amount,String payment_method) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.amount = amount;
        this.payment_method = payment_method;
    }

    // Getters and setters
    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id= payment_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public double getAmount() {
    	return amount;
    }
    
    public void setAmount(double amount) {
    	this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
