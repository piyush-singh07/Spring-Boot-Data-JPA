package com.app.service;

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
	
	public Iterable<Book> getBooksByBookId(Integer bookId)
	{
		return bookDao.findAllBookByBookId(bookId);
	}

}
