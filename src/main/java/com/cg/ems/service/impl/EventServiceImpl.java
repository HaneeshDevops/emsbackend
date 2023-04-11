package com.cg.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.EventDao;
import com.cg.ems.dto.EventDTO;
import com.cg.ems.entity.Event;
import com.cg.ems.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDao eventDao;
	

	@Override
	public EventDTO saveEvent(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		Event event= new Event();
		BeanUtils.copyProperties(eventDTO, event);
		eventDao.save(event);
		return eventDTO;
	}

	@Override
	public EventDTO updateEvent(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		Event event= new Event();
		event.setEventId(eventDTO.getEventId());
		BeanUtils.copyProperties(eventDTO, event);
		eventDao.save(event);
		return eventDTO;
	}

	@Override
	public boolean deleteEvent(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		Event event= new Event();
		BeanUtils.copyProperties(eventDTO, event);
		eventDao.delete(event);
		
		return true;
	}

	//@Override
	public EventDTO getById(int eventId) {
		// TODO Auto-generated method stub
		Optional<Event> event=eventDao.findById(eventId);
		if(event.isPresent()) {
			EventDTO dto=new EventDTO();
			BeanUtils.copyProperties(event.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<EventDTO> findALL() {
		// TODO Auto-generated method stub
		Iterable<Event> list=eventDao.findAll();
		List<EventDTO> dtos=new ArrayList<>();
		for(Event even:list) {
			EventDTO dto=new EventDTO();
			BeanUtils.copyProperties(even, dto);
			dtos.add(dto);
			
		}
		
		return dtos;
	}




	


}
