package com.webapp.bean;

import java.sql.Date;

public class Request {
	
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public String getHawkerUsername() {
		return hawkerUsername;
	}
	public void setHawkerUsername(String hawkerUsername) {
		this.hawkerUsername = hawkerUsername;
	}
	private String customerUsername;
	private String hawkerUsername;
	public Date getRequestAcceptDate() {
		return requestAcceptDate;
	}
	public void setRequestAcceptDate(Date requestAcceptDate) {
		this.requestAcceptDate = requestAcceptDate;
	}
	private Date requestAcceptDate;

}
