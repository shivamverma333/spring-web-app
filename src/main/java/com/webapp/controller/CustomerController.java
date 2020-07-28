package com.webapp.controller;

import java.sql.SQLException;
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

import com.webapp.bean.CurrentHawkerDetails;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.LeaveDate;
import com.webapp.bean.Login;
import com.webapp.bean.PaymentDetails;
import com.webapp.bean.Register;
import com.webapp.bean.Request;
import com.webapp.bean.Search;
import com.webapp.service.CustomerService;
import com.webapp.service.CustomerServiceImpl;
import com.webapp.service.HawkerService;
import com.webapp.service.HawkerServiceImpl;
import com.webapp.util.Payment;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	ArrayList<HawkerDetails> list;
	
	
	private boolean isLoggedIn(HttpSession session){
		if(session.getAttribute("loggedin")==null||!(boolean)session.getAttribute("loggedin")||session.getAttribute("username")==null) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(Model model,HttpSession session) {
		if(isLoggedIn(session))
			return "redirect:/customer/dashboard";
		model.addAttribute("loginForm", new Login());
		return "customerLogin";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") Login user,BindingResult result,RedirectAttributes ra,HttpSession session) {
		if(result.hasErrors()) {
			return "customerLogin";
		}
		CustomerService cs=new CustomerServiceImpl();
		boolean verify=cs.checkLogin(user);
		if(verify) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("loggedin", true);
			session.setAttribute("customer", cs.getCustomerDetails(user.getUsername()));
			return "redirect:/customer/dashboard";
		}
		ra.addFlashAttribute("error","Invalid credentials. Please try again.");
		return "redirect:/customer/login"; 
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerGet(Model model,HttpSession session) {
		if(isLoggedIn(session))
			return "redirect:/customer/dashboard";
		model.addAttribute("registerForm",new Register());
		return "customerRegister";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registerForm")Register register,BindingResult result,HttpSession session ,RedirectAttributes ra) {
		if(result.hasErrors()) {
			return "customerRegister";
		}
		CustomerService cs=new CustomerServiceImpl();
		boolean save=cs.saveCustomer(register);
		if(save) {
			session.setAttribute("loggedin", true);
			session.setAttribute("username",register.getUsername());
			session.setAttribute("customer", cs.getCustomerDetails(register.getUsername()));
			return "redirect:/customer/dashboard";
		}
		ra.addFlashAttribute("error", "Registration failed. Please try again.");
		return "redirect:/customer/register";

	}
	
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String dashboard(HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		return "customerDashBoard";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String getSearchPage(Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		model.addAttribute("search", new Search());
		return "hawkerSearch";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String searchHawker(@Valid @ModelAttribute("searchQuery") Search search,BindingResult result,RedirectAttributes ra,Model model){
		if(result.hasErrors()) {
			return "hawkerSearch";
		}
		return "redirect:/customer/search/"+search.getSearch();	
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String getUpdatePage(Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		model.addAttribute("updateForm",session.getAttribute("customer"));
		return "updateCustomer";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("updateForm") CustomerDetails cd,BindingResult result,RedirectAttributes ra,HttpSession session) {
		if(result.hasErrors()) {
			return "updateCustomer";
		}
		CustomerService cs=new CustomerServiceImpl();
		boolean success=cs.updateCustomer(cd);
		if(success) {
			session.setAttribute("customer",cs.getCustomerDetails(cd.getUsername()));
			return "redirect:/customer/dashboard";
		}
		ra.addFlashAttribute("error","Update Failed.Please try again");
		return "redirect:/customer/update";
		
	}
	
	@RequestMapping(value="/search/{service}",method=RequestMethod.GET)
	public String getSearchedHawkers(@PathVariable("service") String service,RedirectAttributes ra,Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		CustomerService cs=new CustomerServiceImpl();
		list=cs.findHawkers(service);
		if(list.isEmpty()) {
			ra.addFlashAttribute("error", "No Hawkers found for searched service.");
			return "redirect:/customer/search";
		}
		model.addAttribute("list",list);
		model.addAttribute("service",service);
		return "showSearchedHawkers";
		
	}
	
	@RequestMapping(value="/search/{service}/{hawkerUsername}",method=RequestMethod.GET)
	public String getHawkerDetailsPage(@PathVariable("service")String service,@PathVariable("hawkerUsername")String hawkerUsername,Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		HawkerService hs=new HawkerServiceImpl();
		HawkerDetails hawker=hs.getHawkerDetails(hawkerUsername);
		model.addAttribute("hawker",hawker);
		return "hawkerDetailsPage";
	}
	
	
	@RequestMapping(value="/search/{service}/{hawkerUsername}/request",method=RequestMethod.GET)
	public String requestHawker(@PathVariable("service") String service,@PathVariable("hawkerUsername")String hawkerUsername,HttpSession session,RedirectAttributes ra) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		String customerUsername=(String)session.getAttribute("username");
		Request r=new Request();
		r.setCustomerUsername(customerUsername);
		r.setHawkerUsername(hawkerUsername);
		CustomerService cs=new CustomerServiceImpl();
		boolean save=false;
		try {
			save = cs.saveRequest(r);
		} catch (SQLException e) {
			ra.addFlashAttribute("error","Already Requested");
			return "redirect:/customer/search/"+service+"/"+hawkerUsername;
		}
		if(save) {
			return "customerDashBoard";
		}
		ra.addFlashAttribute("error","Request send failed");
		return "redirect:/customer/search/"+service+"/"+hawkerUsername;
	}
	
	@RequestMapping(value="/requested",method=RequestMethod.GET)
	public String getRequestedHawkers(HttpSession session,Model model) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		String customerUsername=(String)session.getAttribute("username");
		CustomerService cs=new CustomerServiceImpl();
		ArrayList<HawkerDetails> list=cs.getRequestedHawkers(customerUsername);
		model.addAttribute("list", list);
		return "viewRequestedHawkers";
	}
	
	@RequestMapping(value="/currentHawkers",method=RequestMethod.GET)
	public String getCurrentHawker(HttpSession session,Model model) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		String customerUsername=(String)session.getAttribute("username");
		CustomerService cs=new CustomerServiceImpl();
		ArrayList<HawkerDetails> list=cs.getCurrentHawkers(customerUsername);
		model.addAttribute("list", list);
		return "viewCurrentHawkers";
	}
	
	@RequestMapping(value="/currentHawkers/{hawkerUsername}",method=RequestMethod.GET)
	public String getCurrentHawkerDetails(@PathVariable("hawkerUsername")String hawkerUsername,Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/customer/login";
		HawkerService hs=new HawkerServiceImpl();
		Request request=new Request();
		request.setHawkerUsername(hawkerUsername);
		request.setCustomerUsername((String) session.getAttribute("username"));
		ArrayList<PaymentDetails> paymentHistory=new ArrayList<>();
		paymentHistory=hs.getPaymentHistory(request);
		CurrentHawkerDetails hawker=hs.getCurrentHawkerDetails(request);
		request=hs.getRequestAcceptDate(request);
		Payment payment=new Payment();
		boolean checkPayment=payment.todayDateCheck(request.getRequestAcceptDate());
		model.addAttribute("paymentHistory",paymentHistory);
		model.addAttribute("checkPayment",checkPayment);
		if(!model.containsAttribute("dateForm")) {
			model.addAttribute("dateForm", new LeaveDate());
		}
		model.addAttribute("hawker",hawker);
		return "viewCurrentHawkerDetails";
	}
	
	
	@RequestMapping(value="/currentHawkers/{hawkerUsername}",method=RequestMethod.POST)
	public String saveLeaveDate(@Valid @ModelAttribute("dateForm")LeaveDate dateForm,BindingResult result, @PathVariable("hawkerUsername")String hawkerUsername,RedirectAttributes ra,Model model) {
		if(result.hasErrors()) {
			ra.addFlashAttribute("org.springframework.validation.BindingResult.dateForm", result);
			ra.addFlashAttribute("result",result);
			ra.addFlashAttribute("dateForm", dateForm);
			return "redirect:/customer/currentHawkers/"+hawkerUsername;
		}
		CustomerService cs=new CustomerServiceImpl();
		ArrayList<String> status=cs.saveLeaveDate(dateForm);
		if(status.get(0).equals("Success")) {
			ra.addFlashAttribute("success","Leave date added successfully.");
			return "redirect:/customer/currentHawkers/"+hawkerUsername;
		}
		ra.addFlashAttribute("error",status.get(1));
		return "redirect:/customer/currentHawkers/"+hawkerUsername;
	}
	

	
}
