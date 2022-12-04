package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String salary;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Organization.class, optional = false)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    public Organization organizationId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Vehicle.class, optional = false)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    public Vehicle vehicleId;

    public Driver() {
    }

    public Driver(Long id, String name, String salary, Organization organizationId, Vehicle vehicleId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.organizationId = organizationId;
        this.vehicleId = vehicleId;
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

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organization) {
        this.organizationId = organization;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicle) {
        this.vehicleId = vehicle;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }
}
