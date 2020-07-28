package com.webapp.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.webapp.service.HawkerService;
import com.webapp.service.HawkerServiceImpl;

public class UniqueHawkerValidator implements ConstraintValidator<UniqueHawker,String>{

	@Override
	public void initialize(UniqueHawker constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		HawkerService hs=new HawkerServiceImpl();
		boolean valid=hs.checkHawkerUsername(username);
		if(valid) {
			return true;
		}
		return false;
	}




}