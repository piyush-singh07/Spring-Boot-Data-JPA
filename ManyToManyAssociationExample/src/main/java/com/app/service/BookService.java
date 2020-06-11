package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookDao;
import com.app.entities.Book;

@Service("bookService")
public class BookService {

	@Autowired
	private BookDao bookDao;

	public Iterable<Book> saveBooks(Iterable<Book> books) {
		return bookDao.saveAll(books);
	}
	
	public List<Book> getBooksByBookId(Integer bookId)
	{
		return bookDao.findAllBookByBookId(bookId);
	}

}
