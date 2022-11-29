package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Vehicle implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public int price;
	public int mileage;
	public String releaseDate;
	public String carId;
	public String owner;
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "car_brand_id", referencedColumnName = "id")
	public CarBrand carBrandId;
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	private Organization organizationId;
	@OneToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "driver_id", referencedColumnName = "id")
	private Driver driverId;
	@OneToMany(targetEntity = Driver.class, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "vehicleId", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Driver> drivers;
	public Vehicle() {
	}
	
	public Vehicle(int price, int mileage, String releaseDate, String carId, String owner, CarBrand carBrandId, Organization organizationId, Driver driverId) {
		this.price = price;
		this.mileage = mileage;
		this.releaseDate = releaseDate;
		this.carId = carId;
		this.owner = owner;
		this.carBrandId = carBrandId;
		this.organizationId = organizationId;
		this.driverId = driverId;
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
