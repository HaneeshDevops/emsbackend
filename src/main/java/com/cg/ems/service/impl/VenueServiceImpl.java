package com.cg.ems.service.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.VenueDao;
import com.cg.ems.dto.VenueDTO;
import com.cg.ems.entity.Venue;
import com.cg.ems.exception.VenueNotFoundException;
import com.cg.ems.service.VenueService;
@Service
public class VenueServiceImpl implements VenueService{

	@Autowired
	 private VenueDao venueDao;
	
	@Override
	public VenueDTO addVenue(VenueDTO venueDTO) {
		// TODO Auto-generated method stub
		Venue venue = new Venue();
		BeanUtils.copyProperties(venueDTO, venue);
		Venue venuesave=venueDao.save(venue);
		venueDTO.setVenueId(venuesave.getVenueId());
		return venueDTO;
	}

	@Override
	public VenueDTO updateVenue(VenueDTO venueDTO) {
		// TODO Auto-generated method stub
		Venue venue=new Venue();
		venue.setVenueId(venueDTO.getVenueId());
		BeanUtils.copyProperties(venueDTO, venue);
		
		venueDao.save(venue);
		return venueDTO;
	
	}
     
	@Override
	public boolean deleteVenue(VenueDTO venueDTO) {
		// TODO Auto-generated method stub
		Venue venue=new Venue();
		BeanUtils.copyProperties(venueDTO, venue);
		venue.setVenueId(venueDTO.getVenueId());
		venueDao.delete(venue);
		return true;
	}
	
	@Override
	public VenueDTO getById(int venueId) {
		// TODO Auto-generated method stub
		
		Optional<Venue> venue =venueDao.findById(venueId);
		if (venue.isPresent()) {
		  VenueDTO dto = new VenueDTO();
		  BeanUtils.copyProperties(venue.get(), dto);
		return dto;
	}
    throw new VenueNotFoundException("Venue is not available");	
}
	

	@Override
	public List<VenueDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Venue> list = venueDao.findAll();
		List<VenueDTO> dtos=new ArrayList<>();
		for(Venue venue :list) {
			VenueDTO dto=new VenueDTO();
			BeanUtils.copyProperties(venue, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	
}
