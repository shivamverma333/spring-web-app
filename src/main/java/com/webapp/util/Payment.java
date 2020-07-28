package com.webapp.util;

import java.sql.Date;
import com.webapp.bean.CurrentHawkerDetails;
import com.webapp.bean.Request;
import com.webapp.service.CustomerService;
import com.webapp.service.CustomerServiceImpl;
import com.webapp.service.HawkerService;
import com.webapp.service.HawkerServiceImpl;


public class Payment {
	
	public boolean todayDateCheck(Date requestAcceptDate) {
		long days;
		Date todayDate=new Date(System.currentTimeMillis());
		CustomerService cs=new CustomerServiceImpl();
		Date lastPaymentDate=cs.getLastPaymentDate();
		if(lastPaymentDate!=null) {
			days=(todayDate.getTime()-lastPaymentDate.getTime())/86400000;
		}else {
			days=(todayDate.getTime()-requestAcceptDate.getTime())/86400000;
		}
		if(days>30) {
			return true;
		}
		return false;
	}
	
	public double calculatePayment(Request request) {
		HawkerService hawkerService =new HawkerServiceImpl();
		CurrentHawkerDetails currentHawkerDetails=hawkerService.getCurrentHawkerDetails(request);
		double amount=Integer.parseInt(currentHawkerDetails.getPlanPrice())-(currentHawkerDetails.getLeaveDates().size())*(Integer.parseInt(currentHawkerDetails.getPlanPrice())/30);
		return amount;
	}

}
