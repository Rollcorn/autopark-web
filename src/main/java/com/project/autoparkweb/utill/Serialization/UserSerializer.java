package com.project.autoparkweb.utill.Serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.project.autoparkweb.mvc.model.dao.User;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<User> {
	
	@Override
	public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject json = new JsonObject();
		
		json.addProperty("id", user.getId());
		json.addProperty("username", user.getUsername());
		json.addProperty("password", user.getPassword());
		json.addProperty("role", user.getRole().getRoleName());
		return json;
	}
}

