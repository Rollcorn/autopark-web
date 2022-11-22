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
    public Long idCarBrand;
    public Long driverId;
    
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public void setCarId(String carId) {
        this.carId = carId;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public Long getIdCarBrand() {
        return idCarBrand;
    }
    
    public void setIdCarBrand(Long idCarBrand) {
        this.idCarBrand = idCarBrand;
    }
    
    public Long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

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

    public Long getCarBrand() {
        return idCarBrand;
    }
}