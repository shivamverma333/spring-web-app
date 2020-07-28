package com.webapp.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.LeaveDate;
import com.webapp.bean.Login;
import com.webapp.bean.PaymentDetails;
import com.webapp.bean.Register;
import com.webapp.bean.Request;
import com.webapp.dao.DAO;

public class CustomerServiceImpl implements CustomerService{
	
	private DAO dao;
	
	

	public CustomerServiceImpl() {
		super();
		dao=new DAO();
	}

	@Override
	public boolean checkLogin(Login user) {
		
		return dao.checkLogin(user);
	}

	@Override
	public boolean saveCustomer(Register register) {

		return dao.saveCustomer(register);
	}

	@Override
	public boolean checkUsername(String username) {
		return dao.checkUsername(username);
	}

	@Override
	public ArrayList<HawkerDetails> findHawkers(String search) {
		ArrayList<HawkerDetails> list=dao.findHawkers(search);
		return list;
	}

	@Override
	public CustomerDetails getCustomerDetails(String username) {
		CustomerDetails cd=dao.getCustomerDetails(username);
		return cd;
	}

	@Override
	public boolean updateCustomer(CustomerDetails cd) {
		return dao.updateCustomer(cd);
	}

	@Override
	public boolean saveRequest(Request r) throws SQLException {
		return dao.saveRequest(r);
	}

	@Override
	public ArrayList<HawkerDetails> getRequestedHawkers(String customerUsername) {
		return dao.getRequestedHawkers(customerUsername);
	}

	@Override
	public ArrayList<HawkerDetails> getCurrentHawkers(String customerUsername) {
		return dao.getCurrentHawkers(customerUsername);
	}
	
	public ArrayList<String> saveLeaveDate(LeaveDate leaveDate){
		return dao.saveLeaveDate(leaveDate);
	}

	@Override
	public Date getLastPaymentDate() {
		return dao.getLastPaymentDate();
	}


}
