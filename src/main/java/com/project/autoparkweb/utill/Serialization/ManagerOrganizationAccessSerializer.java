package com.project.autoparkweb.utill.Serialization;

import com.google.gson.*;
import com.project.autoparkweb.mvc.model.dao.*;

import java.lang.reflect.Type;

public class ManagerOrganizationAccessSerializer implements JsonSerializer<ManagerOrganizationAccess> {
	@Override
	public JsonElement serialize(ManagerOrganizationAccess managerOrganizationAccess, Type type, JsonSerializationContext jsonSerializationContext) {
		JsonObject json = new JsonObject();
		
		json.addProperty("id", managerOrganizationAccess.getId());
		if (managerOrganizationAccess.getManagerId() != null) {
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Manager.class, new ManagerSerializer())
					            .create();
			json.add("user", gson.toJsonTree(managerOrganizationAccess.getManagerId()));
		}
		
		if (managerOrganizationAccess.getOrganizationId() != null) {
			Gson gson = new GsonBuilder()
					            .setPrettyPrinting()
					            .registerTypeAdapter(Organization.class, new OrganizationSerializer())
					            .create();
			json.add("organization", gson.toJsonTree(managerOrganizationAccess.getOrganizationId()));		}
		return json;
	}
}
