package com.webapp.CustomValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;

@Documented
@Constraint(validatedBy=HawkerRegisterPasswordValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsHawkerRegisterPasswordMatches{
	
	String message() default "Password does not match.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}


