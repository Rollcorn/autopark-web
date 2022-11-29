package com.project.autoparkweb.mvc.model.services;

import com.project.autoparkweb.mvc.model.dao.Organization;
import com.project.autoparkweb.mvc.model.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
	final OrganizationRepository organizationRepository;
	
	public OrganizationService(OrganizationRepository organizationRepository) {
		this.organizationRepository = organizationRepository;
	}
	
	public long count() {
		return organizationRepository.count();
	}
	
	public List<Organization> getAll() {
		return organizationRepository.findAll();
	}
	
}
