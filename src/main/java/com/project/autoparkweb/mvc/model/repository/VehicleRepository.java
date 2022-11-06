package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Override
    List<Vehicle> findAll();

    @Query("from Vehicle e left join fetch e.carBrandId where e.carBrandId.carBrandName like concat( '%', :name, '%')")
    List<Vehicle> findByName(@Param("name") String name);
}
