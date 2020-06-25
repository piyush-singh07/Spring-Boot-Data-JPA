package com.app.repositories;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.app.entities.Person;

@Repository("personDao")
public interface PersonDao extends PagingAndSortingRepository<Person, Integer> {
	
	@Async("asyncThreadPool")
	public CompletableFuture<Person> findByEmail(String email);

}
	