package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Person;

@Repository("personRepository")
public interface PersonDao extends CrudRepository<Person, Integer> {

	public List<Person> findByFirstName(String firstName);

	public List<Person> findByLastName(String lastName);
	
	public Person findByFirstNameAndLastName(String firstName, String lastName);
	
	public List<Person> findByFirstNameOrLastName(String firstName, String lastName);
	
	public List<Person> findByAgeLessThanEqual(Integer age);
	
	public List<Person> findByFirstNameLike(String firstName);
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int Age);
	
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);

}
