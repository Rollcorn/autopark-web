package com.project.autoparkweb.utill.Serialization;

import com.google.gson.*;
import com.project.autoparkweb.mvc.model.dao.Driver;
import com.project.autoparkweb.mvc.model.dao.Organization;
import com.project.autoparkweb.mvc.model.dao.Vehicle;

import java.lang.reflect.Type;

public class OrganizationSerializer implements JsonSerializer<Organization> {
    @Override
    public JsonElement serialize(Organization organization, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        json.addProperty("id", organization.getId());
        json.addProperty("name", organization.getName());
        json.addProperty("city", organization.getCity());

        JsonArray vehicles = new JsonArray();
        json.add("vehicles", vehicles);
        for(Vehicle vehicle : organization.getVehicles()) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Vehicle.class, new VehicleSerializer())
                    .create();
            vehicles.add(gson.toJsonTree(vehicle));
        }

        JsonArray drivers = new JsonArray();
        json.add("drivers", drivers);
        for(Driver driver : organization.getDrivers()) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Driver.class, new DriverSerializer())
                    .create();
            drivers.add(gson.toJsonTree(driver));
        }
        return json;
    }
}
