package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String roleName;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public Role() {
	}
	
	@Override
	public String toString() {
		return roleName;
	}
	
	@OneToOne(mappedBy = "roleId", optional = false)
	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@OneToOne(mappedBy = "roleId", optional = false)
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
