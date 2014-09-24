package com.helloWorld.util;
import java.util.List;

import org.springframework.validation.Errors;

public class ErrorApi {
	
	
	public String errorMessage="";
	public String status="BAD_REQUEST"; 
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorApi(Errors errors){
		int count = errors.getErrorCount();
		for(int i =0;i<count;i++){
			errorMessage +="value: "+errors.getFieldErrors().get(i).getRejectedValue()
					+" is not accepted by field "+errors.getFieldErrors().get(i).getField()
					+"\n";
		}
		
	}

}
