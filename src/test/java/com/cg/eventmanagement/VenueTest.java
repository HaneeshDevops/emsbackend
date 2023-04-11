package com.cg.eventmanagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.cg.ems.dao.VenueDao;
import com.cg.ems.dto.VenueDTO;
import com.cg.ems.entity.Venue;
import com.cg.ems.service.impl.VenueServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class VenueTest {
    @Mock
    private VenueDao venueDao;

    @InjectMocks
    private VenueServiceImpl venueService;

    @Test
    public void testAddVenue() {
        // Create a mock input object
        VenueDTO input = new VenueDTO();
        input.venueName = "Paradise Resort";
        input.venueCost = 15600.0;
        input.location = "Bangalore";
        input.venueContact = "paradiseresort@venue.com";

        // Create a mock output object
        Venue output = new Venue();
        output.setVenueId(1);
        BeanUtils.copyProperties(input, output);
        when(venueDao.save(output)).thenReturn(output);

        // Call the method and verify the result
        VenueDTO result = venueService.addVenue(input);
        assertEquals(output.getVenueId(), result.venueId);
        assertEquals(output.getVenueName(), result.venueName);
        assertEquals(output.getVenueCost(), result.venueCost, 0.001);
        assertEquals(output.getLocation(), result.location);
        assertEquals(output.getVenueContact(), result.venueContact);
    }
}
