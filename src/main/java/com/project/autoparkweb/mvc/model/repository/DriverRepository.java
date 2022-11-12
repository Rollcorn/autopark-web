package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
