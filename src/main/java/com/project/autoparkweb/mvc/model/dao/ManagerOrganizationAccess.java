package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "manager_organization_access", schema = "public")
public class ManagerOrganizationAccess {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, targetEntity=Organization.class)
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	private Organization organizationId;
	@OneToOne(cascade = CascadeType.ALL, targetEntity=Manager.class)
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private Manager managerId;

	public ManagerOrganizationAccess() {
	}

	public ManagerOrganizationAccess(Long id, Manager managerId, Organization organizationId) {
		this.id = id;
		this.managerId = managerId;
		this.organizationId = organizationId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
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
				       ", managerId=" + managerId +
				       ", organizationId=" + organizationId +
				       '}';
	}
}
