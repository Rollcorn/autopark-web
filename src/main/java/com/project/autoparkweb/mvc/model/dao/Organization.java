package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL, mappedBy = "organizationId", fetch=FetchType.EAGER)
    private List<Vehicle> vehicles;
    @OneToMany(targetEntity = Driver.class, cascade = CascadeType.ALL, mappedBy = "organizationId", fetch=FetchType.EAGER)
    private List<Driver> drivers;

    public Organization() {
    }

    public Organization(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return name;
    }
}
