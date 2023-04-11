package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.EventDTO;
import com.cg.ems.exception.EventNotFoundException;
import com.cg.ems.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventController {
	@Autowired
	private EventService eventService;

	@PostMapping("/addEvent")
	public EventDTO saveEvent(@RequestBody EventDTO eventDTO) {
		eventService.saveEvent(eventDTO);
		return eventDTO;
	}

	// http://localhost:5432/api/event
	@GetMapping("/event/{eventId}")
	public ResponseEntity<EventDTO> getEventById(@PathVariable Integer eventId) {
		EventDTO eventDTO = eventService.getById(eventId);
		return new ResponseEntity<EventDTO>(eventDTO, HttpStatus.FOUND);
	}

	// http://localhost:5432/api/event
	@PutMapping("/event/{eventId}")
	public ResponseEntity<EventDTO> updateEvent(@RequestBody EventDTO dto) {
		return new ResponseEntity<EventDTO>(eventService.updateEvent(dto), HttpStatus.ACCEPTED);
	}

	// http://localhost:5432/api/event/1
	@DeleteMapping("/event/{eventId}")
	public ResponseEntity<Boolean> deleteEventById(@PathVariable Integer eventId) {
		EventDTO eventDTO = eventService.getById(eventId);
		if (eventDTO != null) {
			eventService.deleteEvent(eventDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new EventNotFoundException("Event with id " + eventId + " does not exist");

	}

	@GetMapping("/event")
	public ResponseEntity<List<EventDTO>> getAllEvent() {
		List<EventDTO> list = eventService.findALL();
		return ResponseEntity.ok(list);
	}
}
