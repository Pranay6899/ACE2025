use foodweb;
CREATE TABLE foodweb.Promotion (
    promotion_id INT PRIMARY KEY,
    restaurant_id INT,
    promotion_details TEXT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (restaurant_id) REFERENCES foodweb.restaurant(restaurant_id)
);
INSERT INTO foodweb.Promotion VALUES (1, 511, '20% off on all orders', '2024-09-01', '2024-09-10');

INSERT INTO foodweb.Promotion VALUES (2, 512, 'Buy 1 Get 1 Free on pizzas', '2024-09-05', '2024-09-15');

INSERT INTO foodweb.Promotion VALUES (3, 513, 'Free dessert with every meal', '2024-09-10', '2024-09-20');

INSERT INTO foodweb.Promotion VALUES (4, 514, '10% off on all vegetarian dishes', '2024-09-12', '2024-09-22');

select * from foodweb.promotion;