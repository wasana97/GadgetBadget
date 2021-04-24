package com.GB.service;
import java.sql.*;
import com.GB.util.DBconnection;
import com.GB.model.Products;
import com.GB.model.*;
import com.GB.util.*;


public class ProductsServices {

	
Connection con = null;
	
	public ProductsServices() {
		
		con = DBconnection.connecter();
	}
	
	 //A common method to connect to the DB
	
	
	public String insertProducts(Products Products)
	 {
		String query = " insert into Products(`ProductID`,`ProductName`,`ResearcherName`,`ProductDescription`,`ProductType`)"
				  + " values (?,?, ?, ?, ?)";
		  
	 String output;
		try {	
				PreparedStatement preparedStatement = con.prepareStatement(query); 
				preparedStatement.setString(1, Products.getProductID());
				preparedStatement.setString(2, Products.getProductName());
				preparedStatement.setString(3, Products.getResearcherName());
				preparedStatement.setString(4,  Products.getProductDescription());
				preparedStatement.setString(5, Products.getProductType()); 
				preparedStatement.execute();
				 con.close();
			  output = "Inserted successfully";
			
		} catch (SQLException e) {
		    output = "Error while inserting the Fund.";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	
	public String readProducts()
	 {
	 String output = "";
	 try
	 {
	
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>ProductID</th><th>Product Name</th><th>Researcher Name</th><th>Product Description</th><th>ProductType</th><th>";
	 String query = "select * from Products";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String ProductID = rs.getString("ProductID");
		 String ProductName = rs.getString("ProductName");
		 String ResearcherName = rs.getString("ResearcherName");
		 String ProductDescription = rs.getString("ProductDescription");
		 String ProductType = rs.getString("ProductType");
		 
		 
	 // Add into the html table
		 output += "<tr><td>" + ProductID + "</td>";
		 output += "<td>" + ProductName + "</td>";
		 output += "<td>" + ResearcherName + "</td>";
		 output += "<td>" + ProductDescription + "</td>";
		 output += "<td>" + ProductType + "</td>";
	 
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the Products.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String updateProducts(Products Products){
	
	 String query = "UPDATE Products SET ProductName=?,ResearcherName=?,ProductDescription=?,ProductType=? WHERE ProductID=?";
	 String output = "";
	 try
	 {
	 
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 
		preparedStatement.setString(1, Products.getProductName());
		preparedStatement.setString(2, Products.getResearcherName());
		preparedStatement.setString(3, Products.getProductDescription());
		preparedStatement.setString(4, Products.getProductType()); 
		preparedStatement.setString(5, Products.getProductID());
		
		
		preparedStatement.execute();
		con.close();
		output = "Updated successfully";
	}
	 catch (Exception e)
	 {
	 output = "Error while updating the Products.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String deleteProducts(Products Products){
		String query = "delete from Products where ProductID=?";
		String output;
		
		
		try {
			
	 if (con == null){
		 return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 // binding values
	 preparedStatement.setString(1,Products.getProductID() );
	 // execute the statement
	 if(preparedStatement.execute()) {
		 output = "Deleted successfully";
	 }else {
		 output = "Deleted successfully";
	 }
		
	 con.close();
	 
	 }catch (Exception e){
	 output = "Error while deleting the Products.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

	
	
}
