package com.webapp.CustomValidation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DateValidator implements ConstraintValidator<DateValidate,String>{

	@Override
	public void initialize(DateValidate constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int day,month,year,leaveDay,leaveMonth,leaveYear;
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.parse(value);
		}catch(ParseException e) {
			return false;
		}
		try {
		LocalDate currentDate=LocalDate.now();
		day=currentDate.getDayOfMonth();
		month=currentDate.getMonthValue();
		year=currentDate.getYear();
		LocalDate leaveDate=LocalDate.parse(value);
		leaveDay=leaveDate.getDayOfMonth();
		leaveMonth=leaveDate.getMonthValue();
		leaveYear=leaveDate.getYear();
		}catch(DateTimeException e) {
			return false;
		}
		if(day>=leaveDay||year!=leaveYear) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Date should lie between current date and end date of service month")
			.addConstraintViolation();
			return false;
		}
		return true;
	}
	

}
