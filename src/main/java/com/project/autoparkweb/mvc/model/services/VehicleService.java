package com.project.autoparkweb.mvc.model.services;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Manger;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.repository.CarBrandRepository;
import com.project.autoparkweb.mvc.model.repository.VehiclePageRepositoryImpl;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import com.project.autoparkweb.utill.Security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
	private final VehiclePageRepositoryImpl vehiclePageRepository;
	private final VehicleRepository vehicleRepository;
	private final CarBrandRepository carBrandRepository;
	Authentication authentication;
	UserDetailsImp userDetailsImp;
	
	@Autowired
	public VehicleService(VehicleRepository vehicleRepository, CarBrandRepository carBrandRepository, VehiclePageRepositoryImpl vehiclePageRepository) {
		this.vehicleRepository = vehicleRepository;
		this.carBrandRepository = carBrandRepository;
		this.vehiclePageRepository = vehiclePageRepository;
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
	
	public List<Vehicle> getByTimestamp(Timestamp createdAt, int limit) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			return vehiclePageRepository.findFromDateWithLimit(createdAt, limit);
		} else {
			throw new UserAccessException();
		}
	}
	
	public List<Vehicle> getByPage(int page, int limit) throws UserAccessException {
		if (userDetailsImp == null) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			userDetailsImp = (UserDetailsImp) authentication.getPrincipal();
		}
		if (userDetailsImp.getUser() instanceof Manger) {
			Page<Vehicle> vehiclesPage = vehicleRepository.findAll(
					PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, "createdAt")));
			return vehiclesPage.getContent();
		} else {
			throw new UserAccessException();
		}
	}
}
