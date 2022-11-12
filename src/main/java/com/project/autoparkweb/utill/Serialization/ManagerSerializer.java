package com.project.autoparkweb.utill.Serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.project.autoparkweb.mvc.model.dao.Manager;
import com.project.autoparkweb.mvc.model.dao.Vehicle;

import java.lang.reflect.Type;

public class ManagerSerializer implements JsonSerializer<Manager> {
	
	@Override
	public JsonElement serialize(Manager manager, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject json = new JsonObject();
		
		json.addProperty("id", manager.getId());
		json.addProperty("username", manager.getUsername());
		json.addProperty("password", manager.getPassword());
		json.addProperty("role", manager.getRole().getRoleName());
		return json;
	}
}

