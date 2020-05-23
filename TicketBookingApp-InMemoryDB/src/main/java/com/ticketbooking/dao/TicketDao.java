package com.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.Ticket;

@Repository("ticketDao")
public interface TicketDao extends CrudRepository<Ticket, Integer> {

}
