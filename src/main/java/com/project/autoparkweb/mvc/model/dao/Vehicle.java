package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public int price;
    public int mileage;
    public String releaseDate;
    public String carId;
    public String owner;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carBrandId", referencedColumnName = "id")
    public CarBrand carBrandId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizationId", referencedColumnName = "id")
    private Organization organizationId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId", referencedColumnName = "id")
    private Driver driverId;
    @OneToMany(targetEntity = Driver.class, cascade = CascadeType.ALL, mappedBy = "vehicleId", fetch=FetchType.EAGER)
    private List<Driver> drivers;
    public Vehicle() {
    }

    public Vehicle(int price, String releaseDate, int mileage, String carId, String owner, CarBrand carBrand,
                   Organization organizationId) {
        this.price = price;
        this.releaseDate = releaseDate;
        this.mileage = mileage;
        this.carId = carId;
        this.owner = owner;
        this.carBrandId = carBrand;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
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

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

    public CarBrand getCarBrandId() {
        return carBrandId;
    }

    public void setId(Long vehicleId) {
        this.id = vehicleId;
    }

    public void setCarBrandId(CarBrand carBrandId) {
        this.carBrandId = carBrandId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                       "id=" + id +
                       ", price=" + price +
                       ", mileage=" + mileage +
                       ", releaseDate='" + releaseDate + '\'' +
                       ", carId='" + carId + '\'' +
                       ", owner='" + owner + '\'' +
                       ", carBrandId=" + carBrandId +
                       ", organizationId=" + organizationId +
                       ", driverId=" + driverId +
                       ", drivers=" + drivers +
                       '}';
    }
}
