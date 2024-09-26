use foodweb;
CREATE TABLE foodweb.Payment (
    payment_id INT PRIMARY KEY,
    order_id INT,
    amount DECIMAL(10,2),
    payment_method VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES foodweb.order(order_id)
);
INSERT INTO foodweb.Payment (payment_id, order_id, amount, payment_method)
VALUES
    (1, 1, 25.99, 'Cash'),
    (2, 2, 18.99, 'Credit Card'),
    (3, 3, 35.50, 'Cash'),
    (4, 4, 45.00, 'Credit Card'),
    (5, 5, 29.99, 'Cash');
select * from foodweb.Payment;