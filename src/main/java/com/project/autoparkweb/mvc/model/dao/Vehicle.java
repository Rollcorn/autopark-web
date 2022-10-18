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
    public String carBrand;

    public Vehicle() {
    }


    public Vehicle(int price, String releaseDate, int mileage, String carId, String owner) {
        this.price = price;
        this.releaseDate = releaseDate;
        this.mileage = mileage;
        this.carId = carId;
        this.owner = owner;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getCarBrand() {
        if (idCarBrand != null) {
            return idCarBrand.getCarBrandName();
        } else {
            return "";
        }
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
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

    public void setIdCarBrand(CarBrand idCarBrand) {
        this.idCarBrand = idCarBrand;
        setCarBrand(idCarBrand.carBrandName);
    }
}
