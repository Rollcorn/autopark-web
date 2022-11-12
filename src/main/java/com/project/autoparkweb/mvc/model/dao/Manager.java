package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	Role roleId;
	public Manager() {
		super();
	}
	
	public Manager(Long id, String username, String password, Role roleId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String login) {
		this.username = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return roleId;
	}
	
	public void setRole(Role role) {
		this.roleId = role;
	}
	
	@Override
	public String toString() {
		return "User{" +
				       "id=" + id +
				       ", login='" + username + '\'' +
				       ", password='" + password + '\'' +
				       ", role='" + roleId + '\'' +
				       '}';
	}
	
	@OneToOne(mappedBy = "managerId", optional = false)
	private ManagerOrganizationAccess managerOrganizationAccess;
	
	public ManagerOrganizationAccess getManagerOrganizationAccess() {
		return managerOrganizationAccess;
	}
	
	public void setManagerOrganizationAccess(ManagerOrganizationAccess managerOrganizationAccess) {
		this.managerOrganizationAccess = managerOrganizationAccess;
	}
}
