package com.project.autoparkweb.mvc.controller;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.project.autoparkweb.mvc.model.dao.*;
import com.project.autoparkweb.mvc.model.repository.*;
import com.project.autoparkweb.mvc.model.services.VehicleService;
import com.project.autoparkweb.utill.Security.UserDetailsImp;
import com.project.autoparkweb.utill.Serialization.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/autopark/rest")
public class VehicleController {
	private final VehicleService vehicleService;
	private final DriverRepository driverRepository;
	private final ManagerOrganizationAccessRepository managerOrganizationAccessRepository;
	private final UserRepository userRepository;
	Authentication authentication;
	
	@Autowired
	public VehicleController(VehicleService vehicleService,
	                         DriverRepository driverRepository,
	                         ManagerOrganizationAccessRepository managerOrganizationAccessRepository,
	                         UserRepository userRepository) {
		this.vehicleService = vehicleService;
		this.driverRepository = driverRepository;
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
			authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImp v = (UserDetailsImp) SecurityContextHolder.getContext()
			                                              .getAuthentication()
			                                              .getPrincipal();
			if (v.getUser() instanceof Manger) {
				String managerId = authentication.getName();
				List<Organization> organizations = managerOrganizationAccessRepository.getOrganizations(managerId);
				Gson gson = new GsonBuilder()
						            .setPrettyPrinting()
						            .registerTypeAdapter(Organization.class, new OrganizationSerializer())
						            .create();
				return new ResponseEntity<>(gson.toJson(organizations), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN.getReasonPhrase(), HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<String> getUsers() {
		try {
			List<User> unit = userRepository.findAll();
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(User.class, new UserSerializer())
					            .create();
			return new ResponseEntity<>(gson.toJson(unit), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/managersorganization")
	public ResponseEntity<String> getManagersOrganization() {
		try {
			List<UserOrganizationAccess> unit = managerOrganizationAccessRepository.findAll();
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(UserOrganizationAccess.class, new ManagerOrganizationAccessSerializer())
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
