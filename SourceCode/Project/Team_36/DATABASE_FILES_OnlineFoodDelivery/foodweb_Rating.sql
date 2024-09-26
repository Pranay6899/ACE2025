use foodweb;
CREATE TABLE foodweb.Rating (
    rating_id INT PRIMARY KEY,
    order_id INT,
    stars INT,
    comment TEXT,
    FOREIGN KEY (order_id) REFERENCES foodweb.order(order_id)
);

INSERT INTO foodweb.Rating(rating_id,order_id,stars,comment)
VALUES
(120,1,4,'good');
INSERT INTO foodweb.Rating(rating_id,order_id,stars,comment)
VALUES
(121,2,3,'Not so bad');
INSERT INTO foodweb.Rating(rating_id,order_id,stars,comment)
VALUES
(122,3,5,'very nice');
INSERT INTO foodweb.Rating(rating_id,order_id,stars,comment)
VALUES
(123,4,3,'Average');
INSERT INTO foodweb.Rating(rating_id,order_id,stars,comment)
VALUES
(124,5,5,'fabulous');
select * from Rating;