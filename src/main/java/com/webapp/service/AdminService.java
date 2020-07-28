package com.webapp.service;

import java.util.ArrayList;

import com.webapp.bean.AdminDetails;
import com.webapp.bean.Login;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;

public interface AdminService {
	
	public boolean checkAdminLogin(Login user);
	public AdminDetails getAdminDetails(String username);
	public ArrayList<CustomerDetails> getAllCustomers();
	public ArrayList<HawkerDetails> getAllHawkers();

}
