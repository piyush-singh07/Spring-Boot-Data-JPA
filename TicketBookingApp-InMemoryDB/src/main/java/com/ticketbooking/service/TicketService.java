package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dao.TicketDao;
import com.ticketbooking.entities.Ticket;

@Service("ticketService")
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	public Iterable<Ticket> getAllTickets() {
		return ticketDao.findAll();

	}

	public Ticket getTicketById(Integer ticketId) {

		return ticketDao.findById(ticketId).orElse(new Ticket());

	}

	public Ticket createTicket(Ticket ticket) {
		return ticketDao.save(ticket);

	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {

		Ticket dbTicketObj = getTicketById(ticketId);
		dbTicketObj.setEmail(newEmail);
		return ticketDao.save(dbTicketObj);

	}

	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
	}

}
