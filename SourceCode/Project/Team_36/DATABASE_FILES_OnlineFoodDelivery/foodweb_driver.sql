use foodweb;
CREATE TABLE foodweb.Driver (
    driver_id INT PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(20),
    vehicle_type VARCHAR(50)
);
insert into driver values(111,"Suresh","268418461","Suzuzki");
insert into driver values(112,"naresh","285618461","Pulsar");
insert into driver values(113,"qureshi","414461","Toyoto");
insert into driver values(114,"ansh","268448178461","bullet");
select * from foodweb.driver;