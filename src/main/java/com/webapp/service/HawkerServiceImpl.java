package com.webapp.service;


import java.util.ArrayList;

import com.webapp.bean.CurrentCustomerDetails;
import com.webapp.bean.CurrentHawkerDetails;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.HawkerRegister;
import com.webapp.bean.Login;
import com.webapp.bean.PaymentDetails;
import com.webapp.bean.Request;
import com.webapp.dao.DAO;
import com.webapp.util.Payment;

public class HawkerServiceImpl implements HawkerService {
	
	private DAO dao;

	public HawkerServiceImpl() {
		super();
		dao=new DAO();
	}

	@Override
	public boolean checkHawkerLogin(Login user){
		
		return dao.checkHawkerLogin(user);
	}

	@Override
	public boolean saveHawker(HawkerRegister register) {
		return dao.saveHawker(register);
	}

	@Override
	public HawkerDetails getHawkerDetails(String username) {
		return dao.getHawkerDetails(username);
	}

	@Override
	public boolean updateHawker(HawkerDetails hd) {
		return dao.updateHawker(hd);
	}

	@Override
	public ArrayList<CustomerDetails> getCustomerRequests(String hawkerUsername) {
		return dao.getCustomerRequests(hawkerUsername);
	}

	@Override
	public boolean requestAccept(Request r) {
		return dao.requestAccept(r);
	}

	@Override
	public ArrayList<CustomerDetails> getCurrentCustomers(String hawkerUsername) {
		return dao.getCurrentCustomers(hawkerUsername);
	}

	@Override
	public CurrentHawkerDetails getCurrentHawkerDetails(Request request) {
		return dao.getCurrentHawkerDetails(request);
	}
	
	@Override
	public Request getRequestAcceptDate(Request request) {
		return dao.getRequestAcceptDate(request);
	}

	@Override
	public CurrentCustomerDetails getCurrentCustomerDetails(Request request) {
		return dao.getCurrentCustomerDetails(request);
	}

	@Override
	public int savePayment(Request request) {
		Payment payment=new Payment();
		double paymentAmount=payment.calculatePayment(request);
		return dao.savePayment(request,paymentAmount);
	}

	@Override
	public ArrayList<PaymentDetails> getPaymentHistory(Request request) {
		return dao.getPaymentHistory(request);
	}

	@Override
	public boolean checkHawkerUsername(String username) {
		return dao.checkHawkerUsername(username);
	}
	
	

}
