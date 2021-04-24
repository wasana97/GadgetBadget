package com.GB.resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.GB.model.payments;
import com.GB.service.paymentsService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@Path("/payments")

public class paymentsResources {

	
	payments paymentObj = new payments();
	// Read API
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readpayments() {
			paymentsService  paymentObj= new paymentsService();

			return paymentObj.readpayments();

		}
		
		// Insert API
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertpayments(String PaymentsDate) {
			JsonObject paymentObject = new JsonParser().parse(PaymentsDate).getAsJsonObject();

			String paymentId = paymentObject.get("paymentId").getAsString();
			String productName = paymentObject.get("productName").getAsString();
			String paymentDate = paymentObject.get("paymentDate").getAsString();
			String amount = paymentObject.get("amount").getAsString();
			String productId = paymentObject.get("productId").getAsString();
			String phone = paymentObject.get("phone").getAsString();

			paymentsService  paymentObj2= new paymentsService();

			paymentObj.setPaymentId(paymentId);
			paymentObj.setProductName(productName);
			paymentObj.setPaymentDate(paymentDate);
			paymentObj.setAmount(amount);
			paymentObj.setProductId(productId);
			paymentObj.setPhone(phone);

			String output =paymentObj2.insertpayments(paymentObj);
			return output;
		}
		
		// Update API
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatepayments(String PaymentsDate) {
			// Convert the input string to a JSON object
			JsonObject paymentObject = new JsonParser().parse(PaymentsDate).getAsJsonObject();
			// Read the values from the JSON object
			String paymentId = paymentObject.get("paymentId").getAsString();
			String productName = paymentObject.get("productName").getAsString();
			String paymentDate = paymentObject.get("paymentDate").getAsString();
			String amount = paymentObject.get("amount").getAsString();
			String productId = paymentObject.get("productId").getAsString();
			String phone = paymentObject.get("phone").getAsString();

			paymentsService  paymentObj1= new paymentsService();

			paymentObj.setPaymentId(paymentId);
			paymentObj.setProductName(productName);
			paymentObj.setPaymentDate(paymentDate);
			paymentObj.setAmount(amount);
			paymentObj.setProductId(productId);
			paymentObj.setPhone(phone);

			String output = paymentObj1.updatepayments(paymentObj);
			return output;
		}
		
		// Delete API
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletepayments(String PaymentsDate) {

			JsonObject paymentObject = new JsonParser().parse(PaymentsDate).getAsJsonObject();

			String paymentId = paymentObject.get("paymentId").getAsString();

			paymentsService  paymentObj2= new paymentsService();
			paymentObj.setPaymentId(paymentId);

			String output = paymentObj2.deletepayments(paymentObj);
			return output;
		}
}
