package com.project.autoparkweb.views.main;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import com.project.autoparkweb.mvc.model.repository.VehicleRepository;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "/vehicle")
@AnonymousAllowed
public class VehicleView {
	private final VehicleRepository repository;
	
	public VehicleView(VehicleRepository repository) {
		this.repository = repository;
	}
	
	public List<Vehicle> listAll() {
		return repository.findAll();
	}
}
