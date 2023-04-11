package com.cg.ems.exception;

public class VenueNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public VenueNotFoundException() {
		super();
	}
	public VenueNotFoundException(String message) {
		super(message);
	}
}
