package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.entities.Person;
import com.app.service.PersonService;

@SpringBootApplication
public class DmImplementationApplication {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DmImplementationApplication.class, args);
	}

	@Bean
	public CommandLineRunner getRunner() {

		return args -> {
			// saveData();
			// getPersonByFirstName();
			// getPersonByLastName();
			// getPersonByFirstAndLastName();
			// getPersonByFirstNameOrLastName();
			// getPersonsByAgeLessThanEqual();
			// getPersonByFirstNameLike();
			// getPersonByLastNameAndAgeLessThanEqual();
			// getPersonByIds();
			// findByLastNameOrderByCreationDateDesc();
		};

	}

	private void getPersonByLastNameAndAgeLessThanEqual() {
		List<Person> list = personService.getPersonByLastNameAndAgeLessThanEqual("Kumar", 25);
		list.forEach(person -> System.out.println(person));

	}

	private void getPersonByFirstNameLike() {
		List<Person> list = personService.getPersonByFirstNameLike("%Kiran%");
		list.forEach(person -> System.out.println(person));
	}

	private void getPersonsByAgeLessThanEqual() {
		Iterable<Person> list = personService.getPersonByAgeLessThanEqual(22);
		list.forEach(person -> System.out.println(person));

	}

	private void getPersonByFirstNameOrLastName() {
		Iterable<Person> list = personService.getPersonByFirstNameOrLastName("Sita", "Kumar");
		list.forEach(person -> System.out.println(person));

	}

	private void getPersonByFirstAndLastName() {
		System.out.println(personService.getPersonByFirstNameAndLastName("Kiran", "Kumar"));

	}

	private void getPersonByLastName() {
		Iterable<Person> list = personService.getPersonByLastName("Kumar");
		list.forEach(person -> System.out.println(person));

	}

	private void getPersonByFirstName() {
		Iterable<Person> list = personService.getPersonByFirstName("Kiran");
		list.forEach(person -> System.out.println(person));
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
		list.forEach(person -> System.out.println(person));

	}
	
	private void getPersonByIds() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<Person> pList = personService.findPersonsById(personList);
		pList.forEach(person->System.out.println(person));
	}
	
	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}
	private Date getDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}
	
	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<Person> personsList = personService.findByLastNameOrderByCreatedDateDesc("Kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person);

		}

	}

}
