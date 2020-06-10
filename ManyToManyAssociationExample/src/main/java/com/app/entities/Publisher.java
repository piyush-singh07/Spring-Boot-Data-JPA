package com.app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="publisher_table")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Publisher {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="publisher_id")
	private Integer publisherId;
	
	@Column(name="publisher_name")
	private String publisherName;
	
	@ManyToMany(mappedBy = "publishers")
	private Set<Book> books;

	public Publisher(String publisherName) {
		this.publisherName = publisherName;
	}
}
