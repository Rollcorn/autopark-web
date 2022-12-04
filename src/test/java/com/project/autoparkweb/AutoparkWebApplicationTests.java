package com.project.autoparkweb;

import com.project.autoparkweb.mvc.model.services.OrganizationService;
import com.project.autoparkweb.utill.VehicleUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoparkWebApplicationTests {
	@Autowired
	VehicleUtils vehicleUtils;
	
	@Autowired
	OrganizationService organizationService;
	
	@Test
	void contextLoads() {
		var v = vehicleUtils.createVehiclesForOrganizations(organizationService.getAll(), 5);
	}
	
}
