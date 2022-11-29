package com.project.autoparkweb.mvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.DriverRepository;
import com.project.autoparkweb.mvc.model.services.OrganizationService;
import com.project.autoparkweb.mvc.model.services.UserAccessException;
import com.project.autoparkweb.mvc.model.services.VehicleService;
import com.project.autoparkweb.utill.Serialization.SerializerUtill;
import com.project.autoparkweb.utill.Serialization.VehicleSerializer;
import com.project.autoparkweb.utill.VehicleUtils;
import com.vaadin.flow.router.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class VehicleController {
	private final VehicleService vehicleService;
	final CarBrandRepository carBrandRepository;
	final DriverRepository driverRepository;
	@Autowired
	VehicleUtils vehicleUtils;
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	public VehicleController(VehicleService vehicleService, CarBrandRepository carBrandRepository, DriverRepository driverRepository) {
		this.vehicleService = vehicleService;
		this.carBrandRepository = carBrandRepository;
		this.driverRepository = driverRepository;
	}
	
	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<String> createVehicles(@RequestBody VehiclePojo vehicle) {
		try {
			Vehicle create = new Vehicle();
			create.price = vehicle.price;
			create.mileage = vehicle.mileage;
			if (vehicle.getCarBrand() != null) {
				create.carBrandId = carBrandRepository.findById(vehicle.idCarBrand).get();
			}
			if (vehicle.carId != null) {
				create.carId = vehicle.carId;
			}
			if (vehicle.owner != null) {
				create.owner = vehicle.owner;
			}
			if (vehicle.getDriverId() != null) {
				create.setDriverId(driverRepository.findById(vehicle.getDriverId()).get());
			}
			if (vehicle.releaseDate != null) {
				create.releaseDate = vehicle.releaseDate;
			}
			vehicleService.createVehicle(create);
			return new ResponseEntity<>(new SerializerUtill().serializeVehicle(create), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<String> getVehicle(@PathVariable Long id) {
		try {
			Optional<Vehicle> unit = vehicleService.getVehicleById(id);
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
					            .create();
			
			return new ResponseEntity<>(gson.toJson(unit.get()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping(value = "/update/{id}")
	public ResponseEntity<String> updateVehicles(@PathVariable Long id, @RequestBody VehiclePojo vehicle) {
		try {
			Optional<Vehicle> unit = vehicleService.getVehicleById(id);
			if (unit.isPresent()) {
				Vehicle origin = unit.get();
				origin.price = vehicle.price;
				origin.mileage = vehicle.mileage;
				if (vehicle.getCarBrand() != null) {
					origin.carBrandId = carBrandRepository.findById(vehicle.idCarBrand).get();
				}
				if (vehicle.carId != null) {
					origin.carId = vehicle.carId;
				}
				if (vehicle.owner != null) {
					origin.owner = vehicle.owner;
				}
				if (vehicle.getDriverId() != null) {
					origin.setDriverId(driverRepository.findById(vehicle.getDriverId()).get());
				}
				if (vehicle.releaseDate != null) {
					origin.releaseDate = vehicle.releaseDate;
				}
				vehicleService.createVehicle(origin);
			}
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
					            .create();
			return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteVehicles(@PathVariable Long id) {
		try {
			vehicleService.deleteVehicleById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping(value = "/random/{count}", produces = "application/json")
	public ResponseEntity<String> getRandomVehicle(@PathVariable int count) {
		try {
			List<Vehicle> unit = vehicleUtils.createVehiclesForOrganizations(organizationService.getAll(), count);
			for (Vehicle v : unit) {
				vehicleService.createVehicle(v);
			}
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
					            .create();
			
			return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	
	@GetMapping(value = "/page/{num}", produces = "application/json")
	public ResponseEntity<String> getVehicleByPage(@PathVariable int num) {
		try {
			Page<Vehicle> unit = vehicleService.getByPage(num);
			if (unit.getTotalPages() < num) {
				throw new NotFoundException("Page not exist");
			}
			List<Vehicle> vehicles = unit.get().collect(Collectors.toList());
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
					            .create();
			
			return new ResponseEntity<>(gson.toJson(vehicles), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (UserAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}

		
	}
}
