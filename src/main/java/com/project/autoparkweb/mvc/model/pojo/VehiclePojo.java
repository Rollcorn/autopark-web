package com.project.autoparkweb.mvc.model.pojo;

import com.project.autoparkweb.mvc.model.dao.CarBrand;

import java.io.Serializable;

public class VehiclePojo implements Serializable {
    static final long serialVersionUID = 42L;
    public int price;
    public String releaseDate;
    public int mileage;
    public String carId;
    public String owner;
    public CarBrand idCarBrand;

    public VehiclePojo() {  }

    public int getPrice() {
        return price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getMileage() {
        return mileage;
    }

    public String getCarId() {
        return carId;
    }

    public String getOwner() {
        return owner;
    }

    public CarBrand getCarBrand() {
        return idCarBrand;
    }
}