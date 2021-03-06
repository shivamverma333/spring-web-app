package com.webapp.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.webapp.CustomValidation.IsPasswordMatches;
import com.webapp.CustomValidation.UniqueUsername;

@IsPasswordMatches
public class Register {
	
	@NotEmpty(message="This is a required field.")
	private String name;
	
	@NotEmpty(message="This is a required field.")
	@UniqueUsername
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
	private String state;
	
	@NotEmpty(message="This is a required field.")
	private String city;
	
	@NotEmpty(message="This is a required field.")
	@Pattern(regexp="^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{8,}$",message="Password must contain at least one letter, at least one number, and be longer than eight charaters.")
	private String password;
	
	@NotEmpty(message="This is a required field.")
	private String confirmPassword;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
