package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PersonDao;
import com.app.entities.Person;

@Service("personService")
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public List<Person> getPersonByFirstName(String firstName) {
		return personDao.findByFirstName(firstName);
	}

	public Iterable<Person> savePersons(List<Person> personList) {
		return personDao.saveAll(personList);
	}

	public List<Person> getPersonByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

	public Person getPersonByFirstNameAndLastName(String firstName, String lastName) {
		return personDao.findByFirstNameAndLastName(firstName, lastName);
	}

	public Iterable<Person> getPersonByFirstNameOrLastName(String firstName, String lastName) {
		return personDao.findByFirstNameOrLastName(firstName, lastName);
	}

	public Iterable<Person> getPersonByAgeLessThanEqual(Integer age) {
		return personDao.findByAgeLessThanEqual(age);
	}

	public List<Person> getPersonByFirstNameLike(String firstName) {
		return personDao.findByFirstNameLike(firstName);
	}

	public List<Person> getPersonByLastNameAndAgeLessThanEqual(String lastName, int age) {
		return personDao.findByLastNameAndAgeLessThanEqual(lastName, age);
	}

	public Iterable<Person> findPersonsById(List<Integer> personList) {
		return personDao.findAllById(personList);
	}

	public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName) {
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

}
