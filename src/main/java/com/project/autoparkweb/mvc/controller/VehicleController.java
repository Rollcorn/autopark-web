package com.project.autoparkweb.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.autoparkweb.mvc.model.dao.*;
import com.project.autoparkweb.mvc.model.repository.*;
import com.project.autoparkweb.mvc.model.services.VehicleService;
import com.project.autoparkweb.utill.Serialization.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/autopark/rest")
public class VehicleController {
    private final VehicleService vehicleService;
    private final OrganizationRepository organizationRepository;
    private final DriverRepository driverRepository;
    private final ManagerRepository managerRepository;
    private final ManagerOrganizationAccessRepository managerOrganizationAccessRepository;
    private final UserRepository userRepository;
    @Autowired
    public VehicleController( VehicleService vehicleService,
                              OrganizationRepository organizationRepository,
                              DriverRepository driverRepository,
                              ManagerRepository managerRepository,
                              ManagerOrganizationAccessRepository managerOrganizationAccessRepository,
                              UserRepository userRepository) {
        this.vehicleService = vehicleService;
        this.organizationRepository = organizationRepository;
        this.driverRepository = driverRepository;
        this.managerRepository = managerRepository;
        this.managerOrganizationAccessRepository = managerOrganizationAccessRepository;
        this.userRepository = userRepository;
    }
    
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
    
    @GetMapping(value = "/managers")
    public ResponseEntity<String> getManagers() {
        try {
            List<Manager> unit = managerRepository.findAll();
            Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .registerTypeAdapter(Manager.class, new ManagerSerializer())
                                .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(value = "/managersorganization")
    public ResponseEntity<String> getManagersOrganization() {
        try {
            List<ManagerOrganizationAccess> unit = managerOrganizationAccessRepository.findAll();
            Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .registerTypeAdapter(ManagerOrganizationAccess.class, new ManagerOrganizationAccessSerializer())
                                .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(value = "/user/{name}")
    public ResponseEntity<String> getManagersOrganization(@PathVariable(name = "name") String name) {
        try {
            User unit = userRepository.findByName(name);

            return new ResponseEntity<>(unit.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
