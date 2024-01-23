package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	@Query("from Book where title=?1")
	public List<Book> findBookByTitle(String title);
	
	@Query("from Book where publisher=?1")
	public List<Book> findBookByPublisher(String publisher);
	
	@Query("from Book where year=?1")
	public List<Book> findBookByYear(int year);

}
