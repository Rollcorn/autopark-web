package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "user_organization_access", schema = "public")
public class UserOrganizationAccess {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, targetEntity=Organization.class)
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	private Organization organizationId;
	@OneToOne(cascade = CascadeType.ALL, targetEntity=User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;

	public UserOrganizationAccess() {
	}

	public UserOrganizationAccess(Long id, User userId, Organization organizationId) {
		this.id = id;
		this.userId = userId;
		this.organizationId = organizationId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User managerId) {
		this.userId = managerId;
	}

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "ManagerOriganiizationAccess{" +
				       "id=" + id +
				       ", managerId=" + userId +
				       ", organizationId=" + organizationId +
				       '}';
	}
}
