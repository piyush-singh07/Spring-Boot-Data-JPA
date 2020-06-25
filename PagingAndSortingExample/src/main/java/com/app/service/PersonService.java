package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.entities.Person;
import com.app.repositories.PersonDao;

@Service("personService")
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public List<Person> findByLastName(String lastName, PageRequest pageRequest) {
		return personDao.findByLastName(lastName, pageRequest);
	}

}
