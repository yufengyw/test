package com.helloWorld.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/"})
public class siteController {
	@RequestMapping(value={"/home"}, method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize ("hasRole('ROLE_USER')")
	public Object showHome(){
		return "/home";
	}
	
	@RequestMapping(value={"/admin/home"}, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Object showAdminHome(){
		return "hello ADMIN";
	}
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET, produces = "application/json")
	public String showLogin(Model model){
		return "/login";
	}
	
	@RequestMapping(value={"/403"}, method = RequestMethod.GET, produces = "application/json")
	public String accessDeined(Model model){
		return "/403";
	}
	
}
