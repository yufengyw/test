package com.helloWorld.web.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.helloWorld.util.ErrorApi;
import com.helloWorld.util.JsonStringPaser;
import com.helloWorld.web.model.User;
import com.helloWorld.web.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class userController {

	@Inject
	private JsonStringPaser parser;
	@Autowired
	private UserService userService;

	@RequestMapping( method = RequestMethod.POST)
	@ResponseBody
	public Object addUser(@Valid @RequestBody User user,Errors errors) throws Exception {
		 if (errors.hasErrors()) {
			// System.out.print(errors.getAllErrors().toString());
			 ErrorApi  errorapi =new  ErrorApi(errors);
			 System.out.println(errorapi.errorMessage);
			 return errorapi;
	        }else{
	    		userService.addUser(user);
		        return user;
	        }
	       
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllUser() throws Exception {
		
		System.out.println(userService.getUser().size());
		return userService.getUser();
	       
	}
	
}
