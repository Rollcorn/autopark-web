DROP table IF EXISTS driver CASCADE;
DROP table IF EXISTS vehicle CASCADE;
DROP table IF EXISTS car_brand CASCADE;
DROP table IF EXISTS organization CASCADE;
DROP table IF EXISTS manager CASCADE;
DROP table IF EXISTS "role" CASCADE;
DROP table IF EXISTS "common_user" CASCADE;
DROP table IF EXISTS manager_organization_access CASCADE;

CREATE TABLE vehicle
(
    id              int          NOT NULL PRIMARY KEY,
    car_id          varchar(150),
    price           varchar(150) NOT NULL,
    release_date    varchar(150),
    mileage         int,
    "owner"         varchar(200),
    driver_id       int,
    car_brand_id    int,
    organization_id int
);

insert INTO vehicle (id, car_id, car_brand_id, price, release_date, mileage, owner, driver_id, organization_id)
VALUES (0, 'A123CAE', 0, 340000, '08.09.2021', 5400, 'ELONE', 0, 0);
insert INTO vehicle (id, car_id, car_brand_id, price, release_date, mileage, owner, driver_id, organization_id)
VALUES (1, 'K321MPB', 1, 100000, '15.10.1997', 90000, 'VALERA', 1, 1);
insert INTO vehicle (id, car_id, car_brand_id, price, release_date, mileage, owner, driver_id, organization_id)
VALUES (2, 'E111ACX', 2, 150000, '07.08.2003', 180000, 'JHON', 2, 2);

CREATE TABLE car_brand
(
    id                int NOT NULL PRIMARY KEY,
    car_brand_name    varchar(150),
    body_type         varchar(150),
    load_capacity     int,
    fuel_type         varchar(150),
    transmission_type varchar(150),
    drivetrain_type   varchar(150)

);

insert into car_brand (id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (0, 'Mercedes-Benz EQB 300 EQB 300', 'SUV', 480, 'electric', 'Automatic', 'All-wheel Drive');
insert into car_brand (id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (1, 'Toyota Camry', 'Sedan', 500, 'Regular Gasoline', '5 speed Manual', 'Front wheel drive');
insert into car_brand (id, car_brand_name, body_type, load_capacity, fuel_type, transmission_type, drivetrain_type)
VALUES (2, 'Honda Accord', 'coupes', 494, 'Regular unleaded', '5-speed manual', 'Front wheel drive');

CREATE TABLE organization
(
    id     int NOT NULL PRIMARY KEY,
    "name" varchar(150),
    city   varchar(150)
);

CREATE TABLE driver
(
    id              int          NOT NULL PRIMARY KEY,
    "name"          varchar(150),
    salary          varchar(150) NOT NULL,
    birthday        varchar(150),
    vehicle_id      int,
    organization_id int
);

insert into organization (id, "name", city)
VALUES (0, 'ORACLE', 'New York');
insert into organization (id, "name", city)
VALUES (1, 'META', 'Los Angeles');
insert into organization (id, "name", city)
VALUES (2, 'Alphabet', 'Los Angeles');

insert into driver (id, "name", salary, birthday, vehicle_id, organization_id)
VALUES (0, 'Sam Smith', 1300, '12.04.1990', 0, 0);
insert into driver (id, "name", salary, birthday, vehicle_id, organization_id)
VALUES (1, 'Jason Statham', 3300, '12.04.1986', 1, 1);
insert into driver (id, "name", salary, birthday, vehicle_id, organization_id)
VALUES (2, 'Val Erasza Voda', 2300, '12.04.19991', 2, 2);

CREATE TABLE "manager"
(
    id         int NOT NULL PRIMARY KEY,
    username   varchar(150),
    "password" varchar(150),
    role_id    int
);

CREATE TABLE "common_user"
(
    id         int NOT NULL PRIMARY KEY,
    username   varchar(150),
    "password" varchar(150),
    role_id    int
);

CREATE TABLE "role"
(
    id        int NOT NULL PRIMARY KEY,
    role_name varchar(150)
);

INSERT INTO "role" (id, role_name)
VALUES (0, 'USER');
INSERT INTO "role" (id, role_name)
VALUES (1, 'ADMIN');

INSERT INTO manager (id, username, "password", role_id)
VALUES (0, 'maria', '$2a$12$2qEC2Qlh9hi0pcsdAC4bMeUvX0/Q83ZsgNMe/DxDdWiUF.RILKKNm', 0);
INSERT INTO manager (id, username, "password", role_id)
VALUES (1, 'alex', '$2a$12$2qEC2Qlh9hi0pcsdAC4bMeUvX0/Q83ZsgNMe/DxDdWiUF.RILKKNm', 0);
INSERT INTO manager (id, username, "password", role_id)
VALUES (3, 'rollcorn', '$2a$12$2qEC2Qlh9hi0pcsdAC4bMeUvX0/Q83ZsgNMe/DxDdWiUF.RILKKNm', 1);
INSERT INTO common_user (id, username, "password", role_id)
VALUES (4, 'boris', '$2a$12$2qEC2Qlh9hi0pcsdAC4bMeUvX0/Q83ZsgNMe/DxDdWiUF.RILKKNm', 1);

CREATE TABLE manager_organization_access
(
    id              int NOT NULL PRIMARY KEY,
    manager_id         int,
    organization_id int
);

INSERT INTO manager_organization_access (id, manager_id, organization_id)
VALUES (0, 0, 0);
INSERT INTO manager_organization_access (id, manager_id, organization_id)
VALUES (1, 0, 1);
INSERT INTO manager_organization_access (id, manager_id, organization_id)
VALUES (2, 1, 2);