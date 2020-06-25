package com.app.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Person;

@Repository("personDao")
public interface PersonDao extends PagingAndSortingRepository<Person, Integer> {
	
	public List<Person> findByLastName(String lastName,Pageable pageRequest);

}
	