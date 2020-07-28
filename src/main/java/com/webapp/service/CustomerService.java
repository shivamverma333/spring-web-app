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

public interface CustomerService {
	
	public boolean checkLogin(Login user);
	public boolean saveCustomer(Register register);
	public boolean checkUsername(String username);
	public ArrayList<HawkerDetails> findHawkers(String search);
	public CustomerDetails getCustomerDetails(String username);
	public boolean updateCustomer(CustomerDetails cd);
	public boolean saveRequest(Request r) throws SQLException;
	public ArrayList<HawkerDetails> getRequestedHawkers(String customerUsername);
	public ArrayList<HawkerDetails> getCurrentHawkers(String customerUsername);
	public ArrayList<String> saveLeaveDate(LeaveDate leaveDate);
	public Date getLastPaymentDate();

}
