package com.ticketbooking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ticket_table")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinataionStation;
	
	@Column(name="journey_date")
	private Date dateOfJourney;
	
	@Column(name="email_id")
	private String email;

	public Ticket(String passengerName, String sourceStation, String destinataionStation, Date dateOfJourney,
			String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinataionStation = destinataionStation;
		this.dateOfJourney = dateOfJourney;
		this.email = email;
	}
}
