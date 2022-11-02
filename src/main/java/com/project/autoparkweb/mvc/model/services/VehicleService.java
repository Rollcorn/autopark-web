package com.project.autoparkweb.mvc.model.services;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<VehiclePojo> getAllPojosVehicles() {
        List<VehiclePojo> pojosVehicles = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle vehicle : vehicles) {
            VehiclePojo vehiclePojo = new VehiclePojo();
            vehiclePojo.carId = vehicle.carId;
            vehiclePojo.idCarBrand = vehicle.getIdCarBrand();
            vehiclePojo.mileage = vehicle.mileage;
            vehiclePojo.owner = vehicle.owner;
            vehiclePojo.price = vehicle.price;
            vehiclePojo.releaseDate =vehicle.releaseDate;
            pojosVehicles.add(vehiclePojo);
        }
        return pojosVehicles;
    }

    public List<CarBrand> getAllBrands() {
        List<CarBrand> car = carBrandRepository.findAll();
        return car;
    }

    public List<Vehicle> getVehicleByName(String name) {
        return vehicleRepository.findByName(name);
    }

}
