package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.app.entities.Person;
import com.app.service.PersonService;

@SpringBootApplication
public class PagingAndSortingExampleApplication {
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(PagingAndSortingExampleApplication.class, args);
	}
	
	
	@Bean 
	CommandLineRunner getRunner()
	{
		return args->{
			
			displayPaging();
			displayPagingWithSorting();
		};
	}


	private void displayPagingWithSorting() {
		
		List<Person> page1= personService.findByLastName("kumar", PageRequest.of(0, 2 ,Sort.by("firstName").descending())) ;
		System.out.println("Printing Page 1 ----- ");
		page1.forEach(System.out::println);
		
		List<Person> page2= personService.findByLastName("kumar", PageRequest.of(1, 2 ,Sort.by("firstName").descending())) ;
		System.out.println("Printing Page 2 ----- ");
		page2.forEach(System.out::println);
		
		List<Person> page3= personService.findByLastName("kumar", PageRequest.of(2, 2 ,Sort.by("firstName").descending())) ;
		System.out.println("Printing Page 3 ----- ");
		page3.forEach(System.out::println);
		
		List<Person> page4= personService.findByLastName("kumar", PageRequest.of(3, 2 ,Sort.by("firstName").descending())) ;
		System.out.println("Printing Page 4 ----- ");
		page4.forEach(System.out::println);
		
		List<Person> page5= personService.findByLastName("kumar", PageRequest.of(4, 2 ,Sort.by("firstName").descending())) ;
		System.out.println("Printing Page 5 ----- ");
		page5.forEach(System.out::println);
		

		
	}


	private void displayPaging() {
		
		List<Person> page1= personService.findByLastName("kumar", PageRequest.of(0, 2)) ;
		System.out.println("Printing Page 1 ----- ");
		page1.forEach(System.out::println);
		
		List<Person> page2= personService.findByLastName("kumar", PageRequest.of(1, 2)) ;
		System.out.println("Printing Page 2 ----- ");
		page2.forEach(System.out::println);
		
		List<Person> page3= personService.findByLastName("kumar", PageRequest.of(2, 2)) ;
		System.out.println("Printing Page 3 ----- ");
		page3.forEach(System.out::println);
		
		List<Person> page4= personService.findByLastName("kumar", PageRequest.of(3, 2)) ;
		System.out.println("Printing Page 4 ----- ");
		page4.forEach(System.out::println);
		
		List<Person> page5= personService.findByLastName("kumar", PageRequest.of(4, 2)) ;
		System.out.println("Printing Page 5 ----- ");
		page5.forEach(System.out::println);
		
	}

}
