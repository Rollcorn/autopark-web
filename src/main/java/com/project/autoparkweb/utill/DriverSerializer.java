package com.project.autoparkweb.utill;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.project.autoparkweb.mvc.model.dao.Driver;

import java.lang.reflect.Type;

public class DriverSerializer implements JsonSerializer<Driver> {
    @Override
    public JsonElement serialize(Driver driver, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();

        json.addProperty("id", driver.getId());
        json.addProperty("name", driver.getName());
        json.addProperty("salary", driver.getSalary());
        if (driver.getOrganizationId() != null) {
            json.addProperty("organization", driver.getOrganizationId().getId());
        }
        if (driver.getVehicleId() != null) {
            json.addProperty("vehicle", driver.getVehicleId().getId());
        }
        return json;
    }
}
