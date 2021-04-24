package com.GB.model;

public class Products {
	private String ProductID;
	private String ProductName;
	private String ResearcherName;
	private String ProductDescription;
	private String ProductType;
	
	
public Products() {
		
	}


public Products(String productID, String productName, String researcherName, String productDescription,
		String productType) {
	super();
	ProductID = productID;
	ProductName = productName;
	ResearcherName = researcherName;
	ProductDescription = productDescription;
	ProductType = productType;
}


public String getProductID() {
	return ProductID;
}


public void setProductID(String productID) {
	ProductID = productID;
}


public String getProductName() {
	return ProductName;
}


public void setProductName(String productName) {
	ProductName = productName;
}


public String getResearcherName() {
	return ResearcherName;
}


public void setResearcherName(String researcherName) {
	ResearcherName = researcherName;
}


public String getProductDescription() {
	return ProductDescription;
}


public void setProductDescription(String productDescription) {
	ProductDescription = productDescription;
}


public String getProductType() {
	return ProductType;
}


public void setProductType(String productType) {
	ProductType = productType;
}


	

}
