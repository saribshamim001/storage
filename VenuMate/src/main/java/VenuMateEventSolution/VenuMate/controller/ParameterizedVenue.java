package VenuMateEventSolution.VenuMate.controller;
import org.springframework.ui.Model;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventJdbcRepository;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParameterizedVenue {


    @Autowired // Add this annotation to inject the repository
    private EventRepository eventRepository;

    @Autowired // Add this annotation to inject the repository
    private EventJdbcRepository eventJdbcRepository;

    @GetMapping("/parameterizedVenue")
    public String showParameterizedVenue(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("venueId", id);
        return "parameterizedVenue";
    }

    @GetMapping("/AllVenuesIds")
    @ResponseBody // Important to return JSON instead of looking for a view
    public List<Integer> getAllVenueIds() {
        List<Integer> ids = eventJdbcRepository.findAllIds();
        System.out.println("Sending venue IDs to client: " + ids);
        return ids;
    }

}