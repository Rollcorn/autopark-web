package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long brandId;
    String carBrandName;
    String bodyType;
    int loadCapacity;
    String fuelType;
    String transmissionType;
    String drivetrainType;
    @OneToMany(mappedBy = "idCarBrand")
    private List<Vehicle> vehicle;

    public CarBrand() {
    }

    public CarBrand(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public CarBrand(String carBrandName, String bodyType, int loadCapacity, String fuelType, String transmissionType,
                    String drivetrainType, List<Vehicle> vehicle) {
        this.carBrandName = carBrandName;
        this.bodyType = bodyType;
        this.loadCapacity = loadCapacity;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.drivetrainType = drivetrainType;
        this.vehicle = vehicle;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getDrivetrainType() {
        return drivetrainType;
    }

    public void setDrivetrainType(String drivetrainType) {
        this.drivetrainType = drivetrainType;
    }
}
