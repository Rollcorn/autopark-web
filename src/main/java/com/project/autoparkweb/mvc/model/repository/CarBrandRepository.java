package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    @Override
    List<CarBrand> findAll();
    @Query("from CarBrand c where c.carBrandName like concat( '%', :name, '%')")
    List<CarBrand> findByName(@Param("name") String name);
    @Override
    <S extends CarBrand> S save(S entity);
}
