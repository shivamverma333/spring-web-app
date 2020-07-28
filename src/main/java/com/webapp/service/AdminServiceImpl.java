package com.webapp.service;

import java.util.ArrayList;

import com.webapp.bean.AdminDetails;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.Login;
import com.webapp.dao.DAO;

public class AdminServiceImpl implements AdminService{
	private DAO dao;
	
	public AdminServiceImpl() {
		super();
		dao=new DAO();
	}
	
	
	@Override
	public boolean checkAdminLogin(Login user) {
		return dao.checkAdminLogin(user);
	}

	
	@Override
	public AdminDetails getAdminDetails(String username) {
		return dao.getAdminDetails(username);
	}


	@Override
	public ArrayList<CustomerDetails> getAllCustomers() {
		return dao.getAllCustomers();
	}


	@Override
	public ArrayList<HawkerDetails> getAllHawkers() {
		return dao.getAllHawkers();
	}

}
