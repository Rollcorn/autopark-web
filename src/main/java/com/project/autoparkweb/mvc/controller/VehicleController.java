package com.project.autoparkweb.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.autoparkweb.mvc.model.dao.Driver;
import com.project.autoparkweb.mvc.model.dao.Organization;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.repository.DriverRepository;
import com.project.autoparkweb.mvc.model.repository.OrganizationRepository;
import com.project.autoparkweb.mvc.model.services.VehicleService;
import com.project.autoparkweb.utill.DriverSerializer;
import com.project.autoparkweb.utill.OrganizationSerializer;
import com.project.autoparkweb.utill.VehicleSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/autopark/rest")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping(value = "/vehicles")
    public ResponseEntity<String> getVehicles() {
        try {
            List<Vehicle> unit = vehicleService.getAllVehicles();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
                    .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/drivers")
    public ResponseEntity<String> getDrivers() {
        try {
            List<Driver> unit = driverRepository.findAll();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Driver.class, new DriverSerializer())
                    .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/organizations")
    public ResponseEntity<String> getOrganizations() {
        try {
            List<Organization> unit = organizationRepository.findAll();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Organization.class, new OrganizationSerializer())
                    .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
