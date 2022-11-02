package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long vehicleId;
    public int price;
    public String releaseDate;
    public int mileage;
    public String carId;
    public String owner;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarBrand", referencedColumnName = "brandId")
    public CarBrand idCarBrand;

    public Vehicle() {
    }

    public Vehicle(int price, String releaseDate, int mileage, String carId, String owner, CarBrand carBrand) {
        this.price = price;
        this.releaseDate = releaseDate;
        this.mileage = mileage;
        this.carId = carId;
        this.owner = owner;
        this.idCarBrand = carBrand;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public CarBrand getIdCarBrand() {
        return idCarBrand;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setIdCarBrand(CarBrand idCarBrand) {
        this.idCarBrand = idCarBrand;
    }
}
