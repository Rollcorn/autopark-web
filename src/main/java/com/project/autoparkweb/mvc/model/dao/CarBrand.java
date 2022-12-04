package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car_brand")
public class CarBrand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String carBrandName;
    String bodyType;
    int loadCapacity;
    String fuelType;
    String transmissionType;
    String drivetrainType;
    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL, mappedBy = "carBrandId", fetch=FetchType.EAGER)
    private List<Vehicle> vehicle;

    public CarBrand() {
    }

    public CarBrand(Long id, String carBrandName, String bodyType, int loadCapacity, String fuelType, String transmissionType,
                    String drivetrainType) {
        this.id = id;
        this.carBrandName = carBrandName;
        this.bodyType = bodyType;
        this.loadCapacity = loadCapacity;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.drivetrainType = drivetrainType;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  carBrandName;
    }
}
