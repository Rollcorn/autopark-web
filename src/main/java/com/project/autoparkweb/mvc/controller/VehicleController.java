package com.project.autoparkweb.mvc.controller;

import com.project.autoparkweb.mvc.VehicleService;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/vehicles")
    public ResponseEntity<List<Vehicle>> getAll() {
        try {
            List<Vehicle> unit = vehicleService.getAllVehicles();
            return new ResponseEntity<>(unit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
