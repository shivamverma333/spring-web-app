package com.webapp.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.webapp.bean.Register;
import com.webapp.service.CustomerService;
import com.webapp.service.CustomerServiceImpl;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String>{

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		CustomerService cs=new CustomerServiceImpl();
		boolean valid=cs.checkUsername(username);
		if(valid) {
			return true;
		}
		return false;
	}




}
