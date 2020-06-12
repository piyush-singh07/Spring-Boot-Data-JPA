package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PersonDao;
import com.app.entities.CustomModel;
import com.app.entities.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	
	public Iterable<Person> savePersons(List<Person> personList) {
		return personDao.saveAll(personList);
	}

	public List<Person> getPersonsByFirstNameOrEmail(String firstName, String email) {
		return personDao.getPersonsByFirstNameOrEmail(firstName, email);
	}

	public List<Person> getPersonByLastName(String lastName) {
		return personDao.getPersonByLastName(lastName);
	}

	public List<CustomModel> getFewColumns(String lastName) {
		return personDao.getFewColumns(lastName);
	}

}
