package com.webapp.bean;

import java.sql.Date;

public class PaymentDetails {
	private String customerUsername;
	private String hawkerUsername;
	private Date dateOfPayment;
	private double paymentAmount;
	
	
	public PaymentDetails(String customerUsername, String hawkerUsername, Date dateOfPayment, double paymentAmount) {
		super();
		this.customerUsername = customerUsername;
		this.hawkerUsername = hawkerUsername;
		this.dateOfPayment = dateOfPayment;
		this.paymentAmount = paymentAmount;
	}
	
	
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
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


}
