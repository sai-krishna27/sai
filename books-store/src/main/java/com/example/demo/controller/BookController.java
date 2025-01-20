package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@Scope(value="request")
public class BookController {
	
	@Autowired
	BookService dao;
	
	@Operation(summary="add new books")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",content = @Content(schema = @Schema(implementation = Book.class),mediaType= "application/json" )),
		@ApiResponse(responseCode = "404",content = @Content(schema = @Schema(implementation = Book.class)))
	})
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.OK).body(dao.insertBook(book));
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
	public ResponseEntity<?> getBookById(@PathVariable("id") int id) throws Exception {
		try {
			return ResponseEntity.ok(dao.getBookById(id));
		}
		catch(Exception e) {
			throw new Exception(""+id);
		}
		
	}

	@PatchMapping("/books")
	public Book patialUpdateBook(@RequestBody String book) throws JsonMappingException, JsonProcessingException {
		return dao.updateBook(book);
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
