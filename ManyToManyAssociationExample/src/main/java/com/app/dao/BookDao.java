package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Book;

@Repository("bookDao")
public interface BookDao extends CrudRepository<Book, Integer> {
	
	public List<Book> findAllBookByBookId(Integer bookId);

}
