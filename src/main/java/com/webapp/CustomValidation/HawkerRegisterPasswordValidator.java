package com.webapp.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.webapp.bean.HawkerRegister;

public class HawkerRegisterPasswordValidator implements ConstraintValidator<IsHawkerRegisterPasswordMatches,Object>{

	@Override
	public void initialize(IsHawkerRegisterPasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object hawkerRegister, ConstraintValidatorContext context) {
		HawkerRegister r=(HawkerRegister)hawkerRegister;
		if(r.getPassword().isEmpty()) {
			return false;
		}
		if(r.getPassword().equals(r.getConfirmPassword()))
			return true;
		return false;
	}


}
