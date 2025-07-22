package VenuMateEventSolution.VenuMate.controller;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;
import java.util.List;

@Controller
public class Venues {

    EventRepository eventRepository;

    @GetMapping("/venues")
    public String showVenuesPage() {
        return "venues"; // returns templates/venue[s.html
    }
}