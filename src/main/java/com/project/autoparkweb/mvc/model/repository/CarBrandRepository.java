package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.CarBrand;
import com.project.autoparkweb.mvc.model.dao.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    @Override
    List<CarBrand> findAll();

    @Override
    <S extends CarBrand> S save(S entity);
}
