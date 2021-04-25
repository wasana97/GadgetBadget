package com.GB.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.GB.model.*;
import com.GB.service.UsersService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




@Path("/Users")
public class UserResource {
	
	Users UserObj = new Users();
	// Read API
	
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readUsers() {
			UsersService UserObj = new UsersService();

			return UserObj.readUsers();

		}
		
		// Insert API
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertUsers(String UserData) {
			JsonObject UserObject = new JsonParser().parse(UserData).getAsJsonObject();

			String UserId = UserObject.get("UserId").getAsString();
			String UFirstName = UserObject.get("UFirstName").getAsString();
			String ULastName = UserObject.get("ULastName").getAsString();
			String Uphone = UserObject.get("Uphone").getAsString();
			String UMail = UserObject.get("UMail").getAsString();
			String UserRole = UserObject.get("UserRole").getAsString();
			String UPassword = UserObject.get("UPassword").getAsString();

			UsersService UserObject2 = new UsersService();

			UserObj.setUserId(UserId);
			UserObj.setUFirstName(UFirstName);
			UserObj.setULastName(ULastName);
			UserObj.setUphone(Uphone);
			UserObj.setUMail(UMail);
			UserObj.setUserRole(UserRole);
			UserObj.setUPassword(UPassword);

			String output =UserObject2.insertUsers(UserObj);
			return output;
		}
		
		
		
		// Update API
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateUsers(String UserData) {
			// Convert the input string to a JSON object
			JsonObject UserObject = new JsonParser().parse(UserData).getAsJsonObject();
			// Read the values from the JSON object
			String UserId = UserObject.get("UserId").getAsString();
			String UFirstName = UserObject.get("UFirstName").getAsString();
			String ULastName = UserObject.get("ULastName").getAsString();
			String Uphone = UserObject.get("Uphone").getAsString();
			String UMail = UserObject.get("UMail").getAsString();
			String UserRole = UserObject.get("UserRole").getAsString();
			String UPassword = UserObject.get("UPassword").getAsString();
			

			UsersService UserObject1 = new UsersService();
			
			UserObj.setUserId(UserId);
			UserObj.setUFirstName(UFirstName);
			UserObj.setULastName(ULastName);
			UserObj.setUphone(Uphone);
			UserObj.setUMail(UMail);
			UserObj.setUserRole(UserRole);
			UserObj.setUPassword(UPassword);

			
			String output = UserObject1.updateUsers(UserObj);
			return output;
		}
		
		// Delete API
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteUsers(String UserData) {

			JsonObject UserObject = new JsonParser().parse(UserData).getAsJsonObject();

			String UserId = UserObject.get("UserId").getAsString();

			UsersService UserObject2 = new UsersService();
			UserObj.setUserId(UserId);

			String output = UserObject2.deleteUsers(UserObj);
			return output;
		}
		
		
		
}
