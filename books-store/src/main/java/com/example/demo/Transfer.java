package com.example.demo;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transfer {
	public static void main(String[] args) throws IOException {
		
		//get call
		RestTemplate rest=new RestTemplate();
		ResponseEntity<String> response=rest.getForEntity("http://localhost:8088/book/1", String.class);
		System.out.println(response.getStatusCodeValue());
		
		ObjectMapper mapper=new ObjectMapper();
		Book book=mapper.readValue(response.getBody(), Book.class);
		ResponseEntity<String> response2=rest.getForEntity("http://localhost:8088/book/publisher/sai", String.class);
		JsonNode node=mapper.readTree(response2.getBody());
		Book book2=mapper.readValue(mapper.writeValueAsBytes(node.get(0)),Book.class);
		System.out.println(book2.toString());
		
		
		//update using post call
		book2.setPublisher("sai krishna");
		Book updatedBook=rest.postForObject("http://localhost:8088/books",book2,book2.getClass());
		System.out.println("updated book "+updatedBook.toString());

		
	}

}
