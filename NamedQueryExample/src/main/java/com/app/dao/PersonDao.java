package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Person;

@Repository("personDao")
public interface PersonDao extends CrudRepository<Person, Integer> {
	
	public List<Person> getPersonDetailsByLastName(String lastName);
	
	
	public Person getPersonDetailsByBothNames(String lastName,String firstName);
	
}
