package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.repo.BookRepo;

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
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
}
