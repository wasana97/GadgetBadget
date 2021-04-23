package com.GB.model;

public class payments {
	

	
	private String paymentId;
	private String productName;
	private String paymentDate;
	private String amount;
	private String productId;
	private String phone;

	
	
	
	public payments(String paymentId, String productName, String paymentDate, String amount, String productId,
			String phone) {
		super();
		this.paymentId = paymentId;
		this.productName = productName;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.productId = productId;
		this.phone = phone;
	}
	public payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
