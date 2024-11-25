package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.repo.BookRepo;

@Component
public class ApplicationContextFile {
	
	@Autowired
	private ApplicationContext context;
	
	public BookRepo getrepo() {
		return context.getBean(BookRepo.class);
	}

}
