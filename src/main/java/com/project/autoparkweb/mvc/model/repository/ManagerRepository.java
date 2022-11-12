package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.Manager;
import com.project.autoparkweb.mvc.model.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
