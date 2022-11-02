package com.project.autoparkweb.utill;

//import com.fasterxml.jackson.databind.JsonSerializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.project.autoparkweb.mvc.model.pojo.VehiclePojo;

        import java.lang.reflect.Type;

public class VehicleSerializer implements JsonSerializer<VehiclePojo> {
//
//    @Override
//    public void serialize(VehiclePojo vehicle, JsonGenerator jgen, SerializerProvider provider) throws IOException {
//        jgen.writeStartArray();
////        jgen.writeNumberField("id", vehicle.vehicleId);
//        jgen.writeStringField("carId", vehicle.carId);
//        jgen.writeStringField("released", vehicle.releaseDate);
//        jgen.writeStringField("owner", vehicle.owner);
//        jgen.writeNumberField("brand", vehicle.idCarBrand.getBrandId());
//        jgen.writeNumberField("price", vehicle.price);
//        jgen.writeNumberField("mileage", vehicle.mileage);
//        jgen.writeEndArray();
//    }

    @Override
    public JsonElement serialize(VehiclePojo vehicle, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();

        json.addProperty("carId", vehicle.carId);
        json.addProperty("released", vehicle.releaseDate);
        json.addProperty("owner", vehicle.owner);
        json.addProperty("brand", vehicle.idCarBrand.getBrandId());
        json.addProperty("price", vehicle.price);
        json.addProperty("mileage", vehicle.mileage);

        return json;
    }
}