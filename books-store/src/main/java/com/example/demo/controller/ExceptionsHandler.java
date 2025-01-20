package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e,WebRequest request){
		return ResponseEntity.badRequest().body("not found for the id "+e.getMessage());
		
	}

}
