package com.project.autoparkweb.mvc.model.repository;

import com.project.autoparkweb.mvc.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//	@Query("select '*' from User e where e.username like :name")
	@Query(value = "select u from User u where u.username like :username")
	User findByName(@Param("username") String username);
}
