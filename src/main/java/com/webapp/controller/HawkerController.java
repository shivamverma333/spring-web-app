package com.webapp.controller;

import java.sql.Date;
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
import com.webapp.bean.HawkerRegister;
import com.webapp.bean.Login;
import com.webapp.bean.PaymentDetails;
import com.webapp.bean.Request;
import com.webapp.service.CustomerService;
import com.webapp.service.CustomerServiceImpl;
import com.webapp.service.HawkerService;
import com.webapp.service.HawkerServiceImpl;
import com.webapp.util.Payment;

@Controller
@RequestMapping("/hawker")
public class HawkerController {
	
	
	private boolean isLoggedIn(HttpSession session){
		if(session.getAttribute("loggedin")==null||!(boolean)session.getAttribute("loggedin")||session.getAttribute("username")==null) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(Model model,HttpSession session) {
		if(isLoggedIn(session))
			return "redirect:/hawker/dashboard";
		model.addAttribute("loginForm", new Login());
		return "hawkerLogin";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") Login user,BindingResult result,RedirectAttributes ra,HttpSession session) {
		if(result.hasErrors()) {
			return "hawkerLogin";
		}
		HawkerService hs=new HawkerServiceImpl();
		boolean verify=hs.checkHawkerLogin(user);
		if(verify) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("loggedin", true);
			session.setAttribute("hawker", hs.getHawkerDetails(user.getUsername()));
			return "redirect:/hawker/dashboard";
		}
		ra.addFlashAttribute("error","Invalid credentials. Please try again");
		return "redirect:/hawker/login"; 
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerGet(Model model,HttpSession session) {
		if(isLoggedIn(session))
			return "redirect:/hawker/dashboard";
		model.addAttribute("registerForm",new HawkerRegister());
		return "hawkerRegister";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registerForm")HawkerRegister register,BindingResult result,HttpSession session ,RedirectAttributes ra,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("result",result);
			return "hawkerRegister";
		}
		HawkerService hs=new HawkerServiceImpl();
		boolean save=hs.saveHawker(register);
		if(save) {
			session.setAttribute("loggedin", true);
			session.setAttribute("username",register.getUsername());
			session.setAttribute("hawker", register);
			return "redirect:/hawker/dashboard";
		}
		ra.addFlashAttribute("error", "Registration failed. Please try again.");
		return "redirect:/hawker/register";

	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String dashboard(HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		return "hawkerDashboard";
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String getUpdatePage(Model model,HttpSession session) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		String username=(String)session.getAttribute("username");
		model.addAttribute("updateForm",session.getAttribute("hawker"));
		return "updateHawker";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("updateForm") HawkerDetails hd,BindingResult result,RedirectAttributes ra,HttpSession session) {
		if(result.hasErrors()) {
			return "updateHawker";
		}
		HawkerService hs=new HawkerServiceImpl();
		boolean success=hs.updateHawker(hd);
		if(success) {
			session.setAttribute("hawker",hs.getHawkerDetails(hd.getUsername()));
			return "redirect:/hawker/dashboard";
		}
		ra.addFlashAttribute("error","Update Failed.Please try again");
		return "redirect:/hawker/update";
	}
	
	
	@RequestMapping(value="/customerRequests",method=RequestMethod.GET)
	public String getcustomerRequests(HttpSession session,Model model) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		String hawkerUsername=(String)session.getAttribute("username");
		HawkerService hs=new HawkerServiceImpl();
		ArrayList<CustomerDetails> list=hs.getCustomerRequests(hawkerUsername);
		model.addAttribute("list", list);
		return "viewCustomerRequests";
	}
	
	@RequestMapping(value="/customerRequests/{customerUsername}",method=RequestMethod.GET)
	public String viewCustomerRequestDetails(@PathVariable("customerUsername")String customerUsername, HttpSession session, Model model) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		CustomerService cs=new CustomerServiceImpl();
		model.addAttribute("customer", cs.getCustomerDetails(customerUsername));
		return "viewCustomerRequestDetails";
	}
	
	
	@RequestMapping(value="/customerRequests/{customerUsername}/{requestResponse}",method=RequestMethod.GET)
	public String viewCustomerRequestDetails(@PathVariable("customerUsername")String customerUsername,@PathVariable("requestResponse")String requestResponse,HttpSession session,RedirectAttributes ra) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		if(requestResponse.equals("accept")) {
			String hawkerUsername=(String)session.getAttribute("username");
			HawkerService hs=new HawkerServiceImpl();
			Request r=new Request();
			r.setCustomerUsername(customerUsername);
			r.setHawkerUsername(hawkerUsername);
			r.setRequestAcceptDate(new Date(System.currentTimeMillis()));
			boolean result=hs.requestAccept(r);
			if(result) {
				ra.addFlashAttribute("success", "Request accepted successfully.");
				return "redirect:/hawker/customerRequests";
			}
			ra.addFlashAttribute("error", "Request accept failed.");
		}
		return "viewCustomerRequestDetails";
	}
	
	
	@RequestMapping(value="/viewCurrentCustomers",method=RequestMethod.GET)
	public String getCurrentCustomers(HttpSession session,Model model) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		String hawkerUsername=(String)session.getAttribute("username");
		HawkerService hs=new HawkerServiceImpl();
		ArrayList<CustomerDetails>list=hs.getCurrentCustomers(hawkerUsername);
		model.addAttribute("list",list);
		return "viewCurrentCustomers";
	}
	
	@RequestMapping(value="/viewCurrentCustomers/{customerUsername}",method=RequestMethod.GET)
	public String viewCurrentCustomerDetails(@PathVariable("customerUsername")String customerUsername, HttpSession session, Model model) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		String hawkerUsername=(String)session.getAttribute("username");
		HawkerService hawkerService=new HawkerServiceImpl();
		HawkerDetails hd=hawkerService.getHawkerDetails(hawkerUsername);
		Request request=new Request();
		request.setHawkerUsername(hawkerUsername);
		request.setCustomerUsername(customerUsername);
		ArrayList<PaymentDetails> paymentHistory=new ArrayList<>();
		paymentHistory=hawkerService.getPaymentHistory(request);
		model.addAttribute("paymentHistory", paymentHistory);
		model.addAttribute("customer", hawkerService.getCurrentCustomerDetails(request));
		request=hawkerService.getRequestAcceptDate(request);
		Payment payment=new Payment();
		boolean checkPayment=payment.todayDateCheck(request.getRequestAcceptDate());
		model.addAttribute("checkPayment",checkPayment);
		model.addAttribute("hawker", hd);
		return "viewCurrentCustomerDetails";
	}
	
	
	@RequestMapping(value="/viewCurrentCustomers/{customerUsername}/payment",method=RequestMethod.POST)
	public String paymentApproved(@PathVariable("customerUsername")String customerUsername,HttpSession session,Model model,RedirectAttributes ra) {
		if(!isLoggedIn(session))
			return "redirect:/hawker/login";
		String hawkerUsername=(String)session.getAttribute("username");
		Request request=new Request();
		request.setCustomerUsername(customerUsername);
		request.setHawkerUsername(hawkerUsername);
		HawkerService hawkerService =new HawkerServiceImpl();
		int status=hawkerService.savePayment(request);
		if(status==1) {
			model.addAttribute("checkPayment", false);
		}else if(status==2){
			ra.addFlashAttribute("error", "Payment already received.");
		}else {
			ra.addFlashAttribute("error", "Payment saved failed.");
		}
		return "redirect:/hawker/viewCurrentCustomers/"+customerUsername;
	}
	
	

}
