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

	public Iterable<Person> savePersons(List<Person> personList) {
		return personDao.saveAll(personList);
	}
	
	public List<Person> getPersonByLastName(String lastName)
	{
		return personDao.getPersonDetailsByLastName(lastName);
	}
	
	public Person getPersonByBoth(String lastName,String firstName)
	{
		return personDao.getPersonDetailsByBothNames(lastName, firstName);
	}

}
