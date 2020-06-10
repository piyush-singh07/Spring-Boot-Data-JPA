package com.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book_table")
@Setter
@Getter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Book.findAllBookByBookId", query = "SELECT DISTINCT b FROM book b JOIN b.publishers p WHERE b.bookId=?1")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bookId;

	@Column(name = "book_name")
	private String bookName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "bookId"), 
	                             inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "publisherId"))
	private Set<Publisher> publishers;

	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}

}
