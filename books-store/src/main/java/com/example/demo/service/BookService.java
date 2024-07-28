package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.repo.BookRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookService {
	@Autowired
	BookRepo bookRepo;
	
	public Book insertBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public List<Book> getBookByTitle(String title) {
		return bookRepo.findBookByTitle(title);
	}
	
	public List<Book> getBookByPublisher(String publisher){
		return bookRepo.findBookByPublisher(publisher);
	}
	
	public List<Book> getBookByYear(int year){
		return bookRepo.findBookByYear(year);
	}
	
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(String book) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.readTree(book);
		Book oldBook=bookRepo.findById(node.get("id").asInt()).get();
		Map<String,String> map=mapper.convertValue(oldBook, Map.class);
		Map<String,String> map2=new HashMap<>();

		map.entrySet().forEach(e->{
			if(node.get(e.getKey())!=null) {
				map2.put(e.getKey(), node.get(e.getKey()).asText());
			}
			else {
				map2.put(e.getKey(),String.valueOf(e.getValue()));
			}
		});
		Book newBook=mapper.convertValue(map2, Book.class);
		
		
		return bookRepo.save(newBook);
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
}
