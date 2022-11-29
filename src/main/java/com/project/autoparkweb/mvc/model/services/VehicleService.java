package com.project.autoparkweb.mvc.model.services;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Manger;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import com.project.autoparkweb.utill.Security.UserDetailsImp;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
	private final VehicleRepository vehicleRepository;
	private final CarBrandRepository carBrandRepository;
	Authentication authentication;
	UserDetailsImp userDetailsImp;
	
	@Autowired
	public VehicleService(VehicleRepository vehicleRepository, CarBrandRepository carBrandRepository) {
		this.vehicleRepository = vehicleRepository;
		this.carBrandRepository = carBrandRepository;
	}
	
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	public List<CarBrand> getAllBrands() {
		return carBrandRepository.findAll();
	}
	
	public List<Vehicle> getVehicleByName(String name) {
		return vehicleRepository.findByName(name);
	}
	
	public void createVehicle(Vehicle vehicle) throws UserAccessException {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		if (userDetailsImp.getUser() instanceof Manger) {
			vehicleRepository.save(vehicle);
			return;
		} else {
			throw new UserAccessException();
		}
	}
	
	public Optional<Vehicle> getVehicleById(Long id) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			return vehicleRepository.findById(id);
		} else {
			throw new UserAccessException();
		}
	}
	
	public void deleteVehicleById(Long id) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			vehicleRepository.deleteById(id);
		} else {
			throw new UserAccessException();
		}
	}
	
	public void updateVehicleById(Long id) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			vehicleRepository.findById(id);
		} else {
			throw new UserAccessException();
		}
	}
	
	public Page<Vehicle> getByPage(int num) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			return vehicleRepository.findAll(PageRequest.of(num, 10, Sort.by(Sort.Direction.ASC, "id")));
		} else {
			throw new UserAccessException();
		}
	}
}
