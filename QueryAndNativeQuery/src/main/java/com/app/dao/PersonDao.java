package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CustomModel;
import com.app.entities.Person;

@Repository("personDao")
public interface PersonDao extends CrudRepository<Person, Integer> {

	@Query(value = "SELECT p FROM Person p WHERE p.firstName=?1 OR p.email=?2")
	public List<Person> getPersonsByFirstNameOrEmail(String firstName, String email);

	// Native Query
	@Query(value = "SELECT * FROM person_table WHERE last_name=?1", nativeQuery = true)
	public List<Person> getPersonByLastName(String lastName);

	@Query(value = "SELECT new com.app.entities.CustomModel(p.personId,p.firstName) FROM Person p WHERE p.lastName=?1")
	public List<CustomModel> getFewColumns(String lastName);

}
