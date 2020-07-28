package com.webapp.bean;

import java.sql.Date;
import java.util.ArrayList;

public class CurrentHawkerDetails {
	

	private String name;
	private String username;
	private String email;
	private String contact;
	private String address;
	private String city;
	private String state;
	private String planName;
	private String planQuantity;
	private String planPrice;
	private ArrayList<Date> leaveDates;
	
	
	public ArrayList<Date> getLeaveDates() {
		return leaveDates;
	}

	public void setLeaveDates(ArrayList<Date> leaveDates) {
		this.leaveDates = leaveDates;
	}


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
