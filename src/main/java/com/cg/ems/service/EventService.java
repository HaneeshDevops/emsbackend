package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dto.EventDTO;

public interface EventService {
	public EventDTO saveEvent(EventDTO eventDTO);
	public EventDTO updateEvent(EventDTO eventDTO);
	public boolean deleteEvent(EventDTO eventDTO);
	public EventDTO getById(int eventId);
	public List<EventDTO> findALL();
}
