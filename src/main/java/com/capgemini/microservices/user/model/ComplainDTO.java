package com.capgemini.microservices.user.model;

public class ComplainDTO {
	private String email;
	private String complain;
	private String productName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "ComplainDTO [email=" + email + ", complain=" + complain + ", productname=" + productName + "]";
	}
	
}
