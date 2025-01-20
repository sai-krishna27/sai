package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class ProcessorImpl {
	
	@Autowired
	public Processor processor;
	public int get() {
		return processor.getData();
	}

}
