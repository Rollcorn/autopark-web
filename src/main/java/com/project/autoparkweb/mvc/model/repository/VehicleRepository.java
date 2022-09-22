package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Override
    List<Vehicle> findAll();
}
