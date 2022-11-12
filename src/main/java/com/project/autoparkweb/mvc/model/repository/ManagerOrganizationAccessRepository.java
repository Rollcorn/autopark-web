package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.ManagerOrganizationAccess;
import com.project.autoparkweb.mvc.model.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerOrganizationAccessRepository extends JpaRepository<ManagerOrganizationAccess, Long> {
}
