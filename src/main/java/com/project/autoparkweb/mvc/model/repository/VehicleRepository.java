package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	@Query("from Vehicle e left join fetch e.carBrandId where e.carBrandId.carBrandName like concat( '%', :name, '%')")
	List<Vehicle> findByName(@Param("name") String name);
	
//	@Query(nativeQuery = true, value = "FROM Vehicle v WHERE v.created > :createdAt LIMIT limit")
//	Optional<List<Vehicle>> getVehicleByPage(@Param("createdAt") Timestamp createdAt, @Param("limit") int limit);
}
