package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dto.VenueDTO;
import com.cg.ems.entity.Venue;

public interface VenueService {
	public VenueDTO addVenue(VenueDTO venueDTO);
	public VenueDTO updateVenue(VenueDTO venueDTO);
	  public boolean deleteVenue(VenueDTO venueDTO);
	  public VenueDTO getById(int venueId);
	 public List<VenueDTO> findAll();
	 
}
 