package com.helloWorld.web.service;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.helloWorld.web.controller.UserQueryController;
import com.helloWorld.web.model.User;

public class ViewUserIntergrationTest {
	MockMvc mockMvc;
	@InjectMocks
	UserQueryController controller;
	@Mock
	UserService userService;
	String username="uername";
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc =standaloneSetup(controller).setMessageConverters(new MappingJackson2HttpMessageConverter() ).build();
		
	}
	@Test
	public void thatViewUserRendersCorrectly() throws Exception{		
		
		when(userService.getUser(any(String.class))).thenReturn(
		           new User(username));

		this.mockMvc.perform(
			   get("/users/{username}",username.toString())
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(jsonPath("$.items['" + YUMMY_ITEM + "']").value(12))
	           .andExpect(jsonPath("$.key").value(key.toString()));
		
	}
	
	
	

}
