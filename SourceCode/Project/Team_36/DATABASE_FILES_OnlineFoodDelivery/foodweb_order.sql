use foodweb;
CREATE TABLE foodweb.order (
    order_id INT PRIMARY KEY,
    customer_id INT,
    restaurant_id INT,
    delivery_address VARCHAR(255),
    total_price DECIMAL(10,2),
    status VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);

INSERT INTO foodweb.order (order_id, customer_id, restaurant_id, delivery_address, total_price, status)
VALUES
    (1, 1, 511, 'Delivery Address 1', 25.99, 'Pending'),
    (2, 2, 512, 'Delivery Address 2', 18.99, 'Delivered'),
    (3, 3, 513, 'Delivery Address 3', 35.50, 'Pending'),
    (4, 4, 514, 'Delivery Address 4', 45.00, 'Processing'),
    (5, 5, 515, 'Delivery Address 5', 29.99, 'Delivered');
select * from foodweb.order;