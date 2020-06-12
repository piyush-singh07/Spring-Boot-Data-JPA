package com.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.entities.CustomModel;
import com.app.entities.Person;
import com.app.service.PersonService;

@SpringBootApplication
public class QueryAndNativeQueryApplication {
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(QueryAndNativeQueryApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner getRunner()
	{
		return args->{
			 //saveData();
			 //getPersonsByFirstNameOrEmail();
			//getPersonByLastName();
			getFewColumns();
		};
	}
	
	//Custom query for getting few columns
	private void getFewColumns() {
		List<CustomModel> persons=personService.getFewColumns("Kumar");
		persons.forEach(System.out::println);
	}


	//Native Query
	private void getPersonByLastName() {
		List<Person> persons= personService.getPersonByLastName("Kumar");
		persons.forEach(System.out::println);
	}


	private void getPersonsByFirstNameOrEmail() {
		List<Person> persons= personService.getPersonsByFirstNameOrEmail("RamKiran", "ganesh@gmail.com");
		persons.forEach(System.out::println);
	}


	private void saveData() {
		List<Person> personList = Arrays.asList(new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran@gmail.com", 20),
				new Person("RamRam", "kumar", "ram@gmail.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth@gmail.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@gmail.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@gmail.com", 50));

		Iterable<Person> list = personService.savePersons(personList);
		list.forEach(System.out::println);

	}

}
