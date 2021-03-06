package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person_table")
@Setter
@Getter
@ToString
@NoArgsConstructor
@NamedQueries(value= {
		@NamedQuery(name = "Person.getPersonDetailsByLastName", 
				query = "SELECT p FROM Person p WHERE p.lastName=?1"),
		@NamedQuery(name = "Person.getPersonDetailsByBothNames", 
		query = "SELECT p FROM Person p WHERE p.lastName=?1 AND p.firstName=?2")
})
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer personId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "email")
	private String email;

	public Person(String firstName, String lastName, String email, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
	}

}
