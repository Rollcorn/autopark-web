DROP table vehicle;
DROP table car_brand;

CREATE TABLE vehicle
(
    vehicle_id              int NOT NULL PRIMARY KEY,
    id_car_brand    int,
    car_id          varchar(150),
    price           varchar(150) NOT NULL,
    release_date    varchar(150),
    mileage         int,
    owner           varchar(200)
);
insert INTO vehicle (vehicle_id, car_id, id_car_brand, price, release_date, mileage, owner)
VALUES (0, 'A123CAE', 0, 340000, '08.09.2021', 5400, 'ELONE');
insert INTO vehicle (vehicle_id, car_id, id_car_brand, price, release_date, mileage, owner)
VALUES (1, 'K321MPB', 1, 100000, '15.10.1997', 90000, 'VALERA');
insert INTO vehicle (vehicle_id, car_id, id_car_brand, price, release_date, mileage, owner)
VALUES (2, 'E111ACX', 2, 150000, '07.08.2003', 180000, 'JHON');

CREATE TABLE car_brand
(
    brand_id              int NOT NULL PRIMARY KEY,
    car_brand_name  varchar(150),
    body_type    varchar(150),
    load_capacity   int,
    fuel_type       varchar(150),
    transmission_type    varchar(150),
    drivetrain_type      varchar(150)

);

insert into car_brand (brand_id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (0, 'Mercedes-Benz EQB 300 EQB 300', 'SUV', 480, 'electric', 'Automatic', 'All-wheel Drive');
insert into car_brand (brand_id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (1, 'Toyota Camry', 'Sedan', 500, 'Regular Gasoline', '5 speed Manual', 'Front wheel drive');
insert into car_brand (brand_id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (2, 'Honda Accord', 'coupes', 494, 'Regular unleaded', '5-speed manual', 'Front wheel drive');