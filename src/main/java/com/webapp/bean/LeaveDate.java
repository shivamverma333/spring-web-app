package com.webapp.bean;
import org.hibernate.validator.constraints.NotEmpty;

import com.webapp.CustomValidation.DateValidate;
public class LeaveDate {
	
@NotEmpty
@DateValidate
private String date;

@NotEmpty
private String customerUsername;

@NotEmpty
private String hawkerUsername;


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

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
