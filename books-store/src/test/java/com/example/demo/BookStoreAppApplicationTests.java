package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class BookStoreAppApplicationTests {
	
	@Spy
	Processor processor;

	@Test
	public void test() {
		MockitoAnnotations.initMocks(this);
		when(processor.getData()).thenReturn(5);
		assertTrue(5==processor.get());
	}
}
