package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.UserOrganizationAccess;
import com.project.autoparkweb.mvc.model.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerOrganizationAccessRepository extends JpaRepository<UserOrganizationAccess, Long> {
	@Query(value = "select o.organizationId from UserOrganizationAccess o where o.userId.username like :managerId")
	List<Organization> getOrganizations(@Param("managerId") String managerId);
}
