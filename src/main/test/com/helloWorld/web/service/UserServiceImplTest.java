package com.helloWorld.web.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
 


public class UserServiceImplTest {

	@Test
	public void thatUserCanBeAddedAndQueried() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		RestTemplate template=new RestTemplate();
		HttpEntity<String> requestEntity = new HttpEntity<String>(RestDataFixture.standardOrderJSON(),headers);
		
	}

}
