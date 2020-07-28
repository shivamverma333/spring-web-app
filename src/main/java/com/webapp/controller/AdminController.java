package com.webapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.Login;
import com.webapp.service.AdminService;
import com.webapp.service.AdminServiceImpl;
import com.webapp.service.CustomerService;
import com.webapp.service.CustomerServiceImpl;
import com.webapp.service.HawkerService;
import com.webapp.service.HawkerServiceImpl;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private boolean isLoggedIn(HttpSession session){
		if(session.getAttribute("loggedin")==null||!(boolean)session.getAttribute("loggedin")||session.getAttribute("username")==null) {
			return false;
		}
		return true;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(Model model,HttpSession session) {
		if(isLoggedIn(session))
			return "redirect:/admin/dashboard";
		model.addAttribute("loginForm", new Login());
		return "adminLogin";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") Login user,BindingResult result,RedirectAttributes ra,HttpSession session) {
		if(result.hasErrors()) {
			return "adminLogin";
		}
		AdminService as=new AdminServiceImpl();
		boolean verify=as.checkAdminLogin(user);
		if(verify) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("loggedin", true);
			session.setAttribute("admin", as.getAdminDetails(user.getUsername()));
			return "redirect:/admin/dashboard";
		}
		ra.addFlashAttribute("error","Invalid credentials. Please try again.");
		return "redirect:/admin/login"; 
	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String dashboard(HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/admin/login";
		return "adminDashboard";
	}
	
	@RequestMapping(value="/customers")
	public String getRegisteredCustomers(HttpSession session) {
		if(!isLoggedIn(session)) {
			return "redirect:/admin/login";
		}
		AdminService as=new AdminServiceImpl();
		ArrayList<CustomerDetails> customers= as.getAllCustomers();
		session.setAttribute("customers", customers);
		return "allCustomers";
	}
	
	
	@RequestMapping(value="/customers/{username}")
	public String getRegisteredCustomerDetails(@PathVariable("username") String username, HttpSession session) {
		if(!isLoggedIn(session)) {
			return "redirect:/admin/login";
		}
		CustomerService cs=new CustomerServiceImpl();
		CustomerDetails customer= cs.getCustomerDetails(username);
		session.setAttribute("customer", customer);
		return "viewCustomerDetails";
	}
	
	@RequestMapping(value="/hawkers")
	public String getRegisteredHawkers(HttpSession session) {
		if(!isLoggedIn(session)) {
			return "redirect:/admin/login";
		}
		AdminService as=new AdminServiceImpl();
		ArrayList<HawkerDetails> hawkers= as.getAllHawkers();
		session.setAttribute("hawkers", hawkers);
		return "allHawkers";
	}
	
	@RequestMapping(value="/hawkers/{username}")
	public String getRegisteredHawkerDetails(@PathVariable("username") String username, HttpSession session) {
		if(!isLoggedIn(session)) {
			return "redirect:/admin/login";
		}
		HawkerService cs=new HawkerServiceImpl();
		HawkerDetails hawker= cs.getHawkerDetails(username);
		session.setAttribute("hawker", hawker);
		return "viewHawkerDetails";
	}

}
