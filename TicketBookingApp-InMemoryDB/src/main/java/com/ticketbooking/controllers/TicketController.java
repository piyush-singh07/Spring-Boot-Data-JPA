package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.entities.Ticket;
import com.ticketbooking.service.TicketService;

@RestController
@RequestMapping("${endpoint.component.ticket}")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "${endpoint.component.ticket.getAllTickets}")
	public Iterable<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}

	@GetMapping(value = "${endpoint.component.ticket.getById}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicketById(ticketId);

	}

	@PostMapping(value = "${endpoint.component.ticket.create}")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);

	}

	@PutMapping(value = "${endpoint.component.ticket.update}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("newEmail") String newEmail) {

		return ticketService.updateTicket(ticketId, newEmail);

	}

	@DeleteMapping(value = "${endpoint.component.ticket.deleteById}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);

	}

}
