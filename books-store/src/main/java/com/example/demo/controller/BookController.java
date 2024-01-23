package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.service.BookService;


@RestController
@Scope(value="request")
public class BookController {
	
	@Autowired
	BookService dao;
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return dao.insertBook(book);
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return dao.getAllBooks();
	}
	
	@GetMapping("/book/title/{title}")
	public List<Book> getBookByTitle(@PathVariable("title") String title){
		return dao.getBookByTitle(title);
	}
	
	@GetMapping("/book/publisher/{publisher}")
	public List<Book> getBookByPublisher(@PathVariable("publisher") String publisher){
		return dao.getBookByPublisher(publisher);
	}
	
	@GetMapping("/book/year/{year}")
	public List<Book> getBookByYear(@PathVariable("year") int year){
		return dao.getBookByYear(year);
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return dao.getBookById(id);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		return dao.updateBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		dao.deleteBook(id);
	}
	
	
}
