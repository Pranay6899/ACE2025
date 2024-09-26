use foodweb;
CREATE TABLE foodweb.Menu (
    menu_id INT PRIMARY KEY,
    restaurant_id INT,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10,2),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);
INSERT INTO foodweb.Menu (menu_id, restaurant_id, name, description, price)
VALUES
    (1, 511, 'Item 1', 'Description 1', 10.99),
    (2, 512, 'Item 2', 'Description 2', 8.99),
    (3, 513, 'Item 3', 'Description 3', 12.50),
    (4, 514, 'Item 4', 'Description 4', 15.99),
    (5, 515, 'Item 5', 'Description 5', 9.99),
    (6, 514, 'Item 6', 'Description 6', 11.99),
    (7, 513, 'Item 7', 'Description 7', 14.99),
    (8, 515, 'Item 8', 'Description 8', 16.50),
    (9, 511, 'Item 9', 'Description 9', 13.99),
    (10,514, 'Item 10', 'Description 10', 10.49);
    select * from foodweb.Menu;
    alter table foodweb.Menu drop column menu_id;

