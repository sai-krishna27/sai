package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.Book;
import com.example.demo.repo.BookRepo;

@SpringBootApplication
public class BooksStoreAppApplication implements CommandLineRunner {

	@Autowired
	BookRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(BooksStoreAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Book("NET Core in Action","sai","978-1-61729-427-3",288,2018));
		repo.save(new Book(".NET Development Using the Compiler API","sai","978-1-84968-742-3",276,2013));
		repo.save(new Book(".Net Framework 4.5 Expert Programming Cookbook","sai","978-1-484221-10-5",176,2016));
		repo.save(new Book(".NET Framework Essentials,2nd Edition","sai","978-0-596-00302-9",320,2002));
		repo.save(new Book(".NET IL Assembler","sai","978-1-4302-6761-4",492,2014));
		repo.save(new Book(".NET Standard 2.0 Cookbook","sai","978-1-78883-466-7",394,2018));
		repo.save(new Book(".NET Test Automation Recipes","sai","978-1-59059-663-0",408,2006));
		repo.save(new Book("10 LED Projects for Geeks","sai","978-1-59327-825-0",240,2018));
		repo.save(new Book("101 Design Ingredients to Solve Big Tech Problems","sai","978-1-93778-532-1",298,2013));
		repo.save(new Book("101 Excel 2013 Tips, Tricks and Timesavers","sai","978-1-118-64218-4",312,2013));
		repo.save(new Book("101 UX Principles","sai","978-1-78883-736-1",414,2016));
		repo.save(new Book("978-0-672-33552-5","sai","78-1-78663-626-1",1152,2011));
		repo.save(new Book("101 Windows Phone 7 Apps","sai","978-1-59327-843-4",288,2018));
		
		
	}

}
