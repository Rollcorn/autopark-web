package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Override
    List<Vehicle> findAll();

    @Query("from Vehicle e left join fetch e.carBrandId where e.carBrandId.carBrandName like concat( '%', :name, '%')")
    List<Vehicle> findByName(@Param("name") String name);

//    @Query("from Vehicle v where (v.created_at < :created_at and v.id < :id) " +
//                   "order by v.created_at DESC, v.id DESC ")
//    List<Vehicle> getVehicleByPage(@Param("page") String create_at, @Param("id") Long id);
}
