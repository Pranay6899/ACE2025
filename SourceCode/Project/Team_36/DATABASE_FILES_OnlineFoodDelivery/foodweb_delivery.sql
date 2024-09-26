use foodweb;
CREATE TABLE foodweb.Delivery (
    delivery_id INT PRIMARY KEY,
    order_id INT,
    driver_id INT,
    delivery_status VARCHAR(50),
    FOREIGN KEY (order_id) REFERENCES foodweb.Order(order_id),
    FOREIGN KEY (driver_id) REFERENCES foodweb.Driver(driver_id)
);
INSERT INTO foodweb.Delivery (delivery_id, order_id, driver_id, delivery_status)
VALUES
    (41, 1, 111, 'Delivered'),
    (42, 2, 112, 'Pending'),
    (43, 3, 113, 'Delivered'),
    (44, 4, 114, 'Processing'),
    (45, 5, 111, 'Delivered');
select * from foodweb.Delivery;