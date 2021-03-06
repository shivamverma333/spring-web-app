package com.webapp.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class HawkerDetails {
	

	@NotEmpty(message="This is a required field.")
	private String name;
	
	@NotEmpty(message="This is a required field.")
	private String username;
	
	@NotEmpty(message="This is a required field.")
	@Email(message="Invalid e-mail.")
	private String email;
	
	@NotEmpty(message="This is a required field.")
	@Size(min=10,max=10,message="Contact number must be of 10 digits.")
	private String contact;
	
	@NotEmpty(message="This is a required field.")
	private String address;
	
	@NotEmpty(message="This is a required field.")
	private String city;
	
	@NotEmpty(message="This is a required field.")
	private String state;
	
	@NotEmpty(message="This is a required field.")
	private String planName;
	
	@NotEmpty(message="This is a required field.")
	private String planQuantity;


	@NotEmpty(message="This is a required field.")
	private String planPrice;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanQuantity() {
		return planQuantity;
	}

	public void setPlanQuantity(String planQuantity) {
		this.planQuantity = planQuantity;
	}

	public String getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(String planPrice) {
		this.planPrice = planPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	

}
