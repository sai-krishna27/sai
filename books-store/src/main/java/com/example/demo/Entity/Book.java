package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="book_title")
	private String title;
	
	@Column(name="book_publisher")
	private String publisher;
	
	

	@Column(name="book_isbn")
	private String isbn;
	
	@Column(name="book_number_of_pages")
	private int pages;
	
	@Column(name="book_year")
	private int year;
	
	public Book(String title, String publisher, String isbn, int pages, int year) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pages = pages;
		this.year = year;
	}
	
	
}
