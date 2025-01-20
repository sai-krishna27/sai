package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Processor {
	
	protected int getData() {
		return 2;
	}
	
	
	public int get() {
		return getData();
	}

}
