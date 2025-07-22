package VenuMateEventSolution.VenuMate.controller;

import VenuMateEventSolution.VenuMate.model.Booking;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.BookingRepository;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewBookings {
    @Autowired
    BookingRepository bookingRepository;
    @GetMapping("/admin/viewBookings")
    public String viewBookings(Model model) {
        List<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "view-bookings";
    }
}