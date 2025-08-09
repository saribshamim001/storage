package VenuMateEventSolution.VenuMate.controller;
import VenuMateEventSolution.VenuMate.model.Booking;
import VenuMateEventSolution.VenuMate.model.Users;
import VenuMateEventSolution.VenuMate.repository.BookingRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Controller
public class booking {

    @Autowired
    private SmsService smsService;

    @GetMapping("/booking")
    public String bookingPage(HttpSession session, Model model){
        Users loggedInUser = (Users) session.getAttribute("loggedInUser");
        if (loggedInUser != null && "ADMIN".equalsIgnoreCase(loggedInUser.getRole())) {
            model.addAttribute("adminBookingNotAllowed", true);
            return "redirect:/admin-cannot-book";
        }
        return "booking";
    }


    @Autowired
    private EmailService emailService;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/book-venue")
    public ResponseEntity<Void> bookVenue(@RequestBody Map<String, String> bookingData) {
        // Extract values from the map
        String name = bookingData.get("name");
        String date = bookingData.get("date");
        String timeSlot = bookingData.get("timeSlot");
        String comments = bookingData.get("comments");
        String capacity = bookingData.get("capacity");
        String decoration = bookingData.get("decoration");
        String stage = bookingData.get("stage");
        String flowers = bookingData.get("flowers");

        Booking booking = new Booking();
        booking.setName(name);
        booking.setCapacity(Integer.parseInt(capacity));
        booking.setTimeslot(timeSlot);
        booking.setDecoration(decoration);
        booking.setStage(stage);
        booking.setFlowers(flowers);

        bookingRepository.save(booking);

        // Email body
        String emailBody = String.format(
                "Booking Confirmation:\n\nVenue: %s\nDate: %s\nTime Slot: %s\nCapacity: %s\nDecoration: %s\nStage: %s\nFlowers: %s\n\nComments: %s\n\nThank you for choosing VenuMate.",
                name, date, timeSlot, capacity, decoration, stage, flowers, comments
        );

        // Send email
        String receiverEmail = "siddiqui00095@gmail.com";
        emailService.sendEmail(receiverEmail, "Booking Confirmation - VenuMate", emailBody);

        String smsMsg = "Your booking for " +name+" is confirmed on the time slot: "+timeSlot;
        smsService.sendSms("923345493325", smsMsg);

        return ResponseEntity.noContent().build(); // HTTP 204
    }



}
