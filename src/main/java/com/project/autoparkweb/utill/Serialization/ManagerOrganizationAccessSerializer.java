package com.project.autoparkweb.utill.Serialization;

import com.google.gson.*;
import com.project.autoparkweb.mvc.model.dao.*;

import java.lang.reflect.Type;

public class ManagerOrganizationAccessSerializer implements JsonSerializer<UserOrganizationAccess> {
	@Override
	public JsonElement serialize(UserOrganizationAccess userOrganizationAccess, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject json = new JsonObject();
		
		json.addProperty("id", userOrganizationAccess.getId());
		if (userOrganizationAccess.getManagerId() != null) {
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(User.class, new UserSerializer())
					            .create();
			json.add("user", gson.toJsonTree(userOrganizationAccess.getManagerId().getId()));
		}
		
		if (userOrganizationAccess.getOrganizationId() != null) {
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Organization.class, new OrganizationSerializer())
					            .create();
			json.add("organization", gson.toJsonTree(userOrganizationAccess.getOrganizationId().getId()));		}
		return json;
	}
}
