package com.capgemini.capstore.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		// After admin login successfully.        		         
		return "adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After customer login successfully.
		String userName = principal.getName(); 
//		System.out.println("User Name: " + userName);        
		return userName;
	}

	@RequestMapping(value = "/merchantInfo", method = RequestMethod.GET)
	public String merchantInfo(Model model, Principal principal) {

		// After merchant login successfully.
		String userName = principal.getName(); 
//		System.out.println("User Name: " + userName);        
		return userName;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		//error page
		if (principal != null) {           

			String message = "Hi " + principal.getName() //
			+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}

		return "403Page";
	}   

}
