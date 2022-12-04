package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface VehiclePageRepository extends JpaRepository<Vehicle, Long> {
	
	List<Vehicle> findFromDateWithLimit(Timestamp createdAt, int limit);
}
