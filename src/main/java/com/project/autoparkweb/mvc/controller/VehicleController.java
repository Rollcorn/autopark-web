package com.project.autoparkweb.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.services.VehicleService;
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

    @GetMapping(value = "/vehicles")
    public ResponseEntity<String> getAll() {
        try {
            List<VehiclePojo> unit = vehicleService.getAllPojosVehicles();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(VehiclePojo.class, new VehicleSerializer())
                    .create();
            return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
