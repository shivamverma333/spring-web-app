package com.webapp.CustomValidation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;

@Documented
@Constraint(validatedBy=UniqueHawkerValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueHawker{
	
	String message() default "Username already exists.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}

