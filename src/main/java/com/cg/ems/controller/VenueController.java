package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.dto.VenueDTO;
import com.cg.ems.exception.VenueNotFoundException;
import com.cg.ems.service.VenueService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://frontend-container:4200")
@RestController
@RequestMapping("/api")
public class VenueController {
	@Autowired
	public VenueService venueService;

	// http://localhost:8081/api/venue

	
	
	@PostMapping("/venue")
	public ResponseEntity<VenueDTO> addVenue(@Valid @RequestBody VenueDTO venueDTO) {
		VenueDTO venue = venueService.addVenue(venueDTO);
		return ResponseEntity.ok(venue);

	}

	// http://localhost:8081/api/fetchVenueById/venueId
	@GetMapping("/fetchVenueById/{venueId}")
	public ResponseEntity<VenueDTO> getVenueByVenueId(@PathVariable int venueId) {

		VenueDTO venueDTO = venueService.getById(venueId);
		if(venueDTO!= null) {
		return new ResponseEntity<VenueDTO>(venueDTO, HttpStatus.FOUND);
		}
		throw new VenueNotFoundException("venue with id" + venueId+ "doesnot exist");
	}
	// http://localhost:8081/api/updateVenue/venueId

	@PutMapping("/updateVenue/{venueId}")
	public ResponseEntity<VenueDTO> updateVenue(@Valid @RequestBody VenueDTO venueDTO) {

		return new ResponseEntity<VenueDTO>(venueService.updateVenue(venueDTO), HttpStatus.ACCEPTED);
	}

	// http://localhost:8081/api/venue
	@DeleteMapping("/venue/{venueId}")
	public ResponseEntity<Boolean> deleteVenueByVenueId(@PathVariable int venueId) {
		VenueDTO venueDTO = venueService.getById(venueId);
		if (venueDTO != null) {
			venueService.deleteVenue(venueDTO);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		throw new VenueNotFoundException("Venue does not exists");
	}

	// http://localhost:8081/api/venue
	@GetMapping("/venue")
	public ResponseEntity<List<VenueDTO>> getAllVenue() {
		List<VenueDTO> list = venueService.findAll();
		return ResponseEntity.ok(list);
	}

}
