package com.GB.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.GB.model.payments;
import com.GB.util.DBconnectionPayments;

public class paymentsService {
	
	
Connection con = null;
	
	public paymentsService() {
		
		con = DBconnectionPayments.connecter();
	}
	
	 //A common method to connect to the DB
	
	
	public String insertpayments(payments payment)
	 {
		String query = " insert into payments(`paymentId`,`productName`,`paymentDate`,`amount`,`productId`,`phone`)"
				  + " values (?,?, ?, ?, ?, ?)";
		  
	 String output;
		try {	
				PreparedStatement preparedStatement = con.prepareStatement(query); 
				preparedStatement.setString(1, payment.getPaymentId());
				preparedStatement.setString(2, payment.getProductName());
				preparedStatement.setString(3, payment.getPaymentDate());
				preparedStatement.setString(4,  payment.getAmount());
				preparedStatement.setString(5, payment.getProductId());
				preparedStatement.setString(6, payment.getPhone()); 
				preparedStatement.execute();
				 con.close();
			  output = "Inserted successfully";
			
		} catch (SQLException e) {
		    output = "Error while inserting the Payment.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	public String readpayments()
	 {
	 String output = "";
	 try
	 {
	
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>Payment Id</th><th>product Name</th><th>payment Date</th><th>Amount</th><th>product Id</th><th>phone number</th></tr>";
	 String query = "select * from payments";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String paymentId = rs.getString("paymentId");
		 String productName = rs.getString("productName");
		 String paymentDate = rs.getString("paymentDate");
		 String amount = rs.getString("amount");
		 String productId = rs.getString("productId");
		 String phone = rs.getString("phone");
	 // Add into the html table
		 output += "<tr><td>" + paymentId + "</td>";
		 output += "<td>" + productName + "</td>";
		 output += "<td>" + paymentDate + "</td>";
		 output += "<td>" + amount + "</td>";
		 output += "<td>" + productId + "</td>";
		 output += "<td>" + phone + "</td>";
	 
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Funds.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String updatepayments(payments payment){
	
	 String query = "UPDATE payments SET productName=?,paymentDate=?,amount=?,productId=?,phone=? WHERE paymentId=?";
	 String output = "";
	 try
	 {
	 
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 
		preparedStatement.setString(1, payment.getProductName());
		preparedStatement.setString(2, payment.getPaymentDate());
		preparedStatement.setString(3, payment.getAmount());
		preparedStatement.setString(4, payment.getProductId());
		preparedStatement.setString(5, payment.getPhone()); 
		preparedStatement.setString(6, payment.getPaymentId());
		
		
		preparedStatement.execute();
		con.close();
		output = "Updated successfully";
	}
	 catch (Exception e)
	 {
	 output = "Error while updating the payments.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String deletepayments(payments payment){
		String query = "delete from payments where paymentId=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1,payment.getPaymentId() );
	 // execute the statement
	 if(preparedStatement.execute()) {
		 output = "Deleted successfully";
	 }else {
		 output = "Deleted successfully";
	 }
		
	 con.close();
	 
	 }catch (Exception e){
	 output = "Error while deleting the payments.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	



}
