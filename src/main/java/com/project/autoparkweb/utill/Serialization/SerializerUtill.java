package com.project.autoparkweb.utill.Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.autoparkweb.mvc.model.dao.Organization;
import com.project.autoparkweb.mvc.model.dao.Vehicle;

import java.util.List;

public class SerializerUtill {
	public static String serializeObject(List<Organization> organizations) {
		Gson gson = new GsonBuilder()
				            .setPrettyPrinting()
				            .registerTypeAdapter(Organization.class, new OrganizationSerializer())
				            .create();
		return gson.toJson(organizations);
	}
	
	public String serializeVehicle(Vehicle vehicle) {
		Gson gson = new GsonBuilder()
				            .setPrettyPrinting()
				            .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
				            .create();
		return gson.toJson(vehicle);
	}
}
