package com.mobileapp.ws.api.ui.controller.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mobileapp.ws.api.ui.model.response.ErrorMessage;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object>handeAnyException(Exception ex,WebRequest request){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		if(errorMessageDesc==null)errorMessageDesc=ex.toString();
		
		ErrorMessage errorMessage= new ErrorMessage(new Date(),errorMessageDesc);
		
		return new ResponseEntity<>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {CustomException.class})
	public ResponseEntity<Object>handeAnyException(CustomException ex,WebRequest request){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		if(errorMessageDesc==null)errorMessageDesc=ex.toString();
		
		ErrorMessage errorMessage= new ErrorMessage(new Date(),errorMessageDesc);
		
		return new ResponseEntity<>(ex,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
