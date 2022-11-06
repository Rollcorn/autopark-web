package com.project.autoparkweb.utill;

//import com.fasterxml.jackson.databind.JsonSerializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.project.autoparkweb.mvc.model.dao.Vehicle;

import java.lang.reflect.Type;

public class VehicleSerializer implements JsonSerializer<Vehicle> {

    @Override
    public JsonElement serialize(Vehicle vehicle, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();

        json.addProperty("carId", vehicle.carId);
        json.addProperty("released", vehicle.releaseDate);
        json.addProperty("owner", vehicle.owner);
        json.addProperty("brand", vehicle.getCarBrandId().getId());
        json.addProperty("price", vehicle.price);
        json.addProperty("mileage", vehicle.mileage);
        json.addProperty("driver", vehicle.getDriverId().getId());
        json.addProperty("organization", vehicle.getOrganizationId().getId());

        return json;
    }
}