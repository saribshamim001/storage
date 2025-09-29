package VenuMateEventSolution.VenuMate.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import VenuMateEventSolution.VenuMate.repository.EventJdbcRepository;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ParameterizedVenue {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedVenue.class);
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
        logger.info("Retrieved venue IDs: ");
        System.out.println("Sending venue IDs to client: " + ids);
        return ids;
    }
}