package com.webapp.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.webapp.bean.Register;

public class PasswordValidator implements ConstraintValidator<IsPasswordMatches,Object>{

	@Override
	public void initialize(IsPasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object register, ConstraintValidatorContext context) {
		Register r=(Register)register;
		if(r.getPassword().isEmpty()) {
			return false;
		}
		if(r.getPassword().equals(r.getConfirmPassword()))
			return true;
		return false;
	}


}
