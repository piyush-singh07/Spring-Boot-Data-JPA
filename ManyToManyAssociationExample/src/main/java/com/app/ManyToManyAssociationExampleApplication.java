package com.app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.entities.Book;
import com.app.entities.Publisher;
import com.app.service.BookService;

@SpringBootApplication
public class ManyToManyAssociationExampleApplication {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyAssociationExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner getRunner() {
		return args -> {
			//saveBooksData();
			getBookDetailsByBookId();
		};
	}

	private void getBookDetailsByBookId() {
		List<Book> bookDetails= bookService.getBooksByBookId(1);
		bookDetails.forEach(System.out::println);
		
	}

	private void saveBooksData() {

		Publisher pubA = new Publisher("PublisherA");
		Publisher pubB = new Publisher("PublisherB");
		Publisher pubC = new Publisher("PublisherC");
		Publisher pubD = new Publisher("PublisherD");
		Publisher pubE = new Publisher("PublisherE");
		Publisher pubF = new Publisher("PublisherF");

		Book bookA = new Book("BookA", new HashSet<>(Arrays.asList(pubA)));
		Book bookB = new Book("BookB", new HashSet<>(Arrays.asList(pubA, pubB)));
		Book bookC = new Book("BookC", new HashSet<>(Arrays.asList(pubC)));
		Book bookD = new Book("BookD", new HashSet<>(Arrays.asList(pubD, pubE, pubF)));
		Book bookE = new Book("BookE", new HashSet<>(Arrays.asList(pubE)));

		bookService.saveBooks(Arrays.asList(bookA, bookB, bookC, bookD, bookE));

	}

}
