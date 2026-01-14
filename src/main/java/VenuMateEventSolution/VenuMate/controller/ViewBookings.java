package VenuMateEventSolution.VenuMate.controller;

import VenuMateEventSolution.VenuMate.model.Booking;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.BookingRepository;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewBookings {
    @Autowired
    BookingRepository bookingRepository;
    private static final Logger logger = LoggerFactory.getLogger(ViewBookings.class);
    @GetMapping("/admin/viewBookings")
    public String viewBookings(Model model) {
        List<Booking> bookings = bookingRepository.findAll();
        logger.info("Fetched {} bookings from the database: {}", bookings.size(), bookings);
        model.addAttribute("bookings", bookings);
        return "view-bookings";
    }
}