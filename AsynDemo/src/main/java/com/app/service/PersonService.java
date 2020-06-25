package com.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Person;
import com.app.repositories.PersonDao;

@Service("personService")
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public CompletableFuture<Person> findByemail(String email) {

		return personDao.findByEmail(email);
	}

}
