package VenuMateEventSolution.VenuMate.rest;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainPage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);
    @Autowired
    EventRepository eventRepository;

//    @GetMapping("/listOfVenues")
//    public List<VenuesList> listOfVenues(){
//        return eventRepository.findAll();
//    }
    @GetMapping("/listOfVenues")
    public Page<VenuesList> listVenues(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {
        return eventRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/Venue/{id}")
    public ResponseEntity<VenuesList> getVenue(@PathVariable Integer id) {
        Optional<VenuesList> venue = eventRepository.findById(id);
        logger.info("Venues list found, now returning the list");
        return venue.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/create")
    public VenuesList create(@RequestBody Map<String,String> body){
        VenuesList venue = new VenuesList();
        venue.setName(body.get("name"));
        venue.setCapacity(Integer.parseInt(body.get("capacity")));
        venue.setTimeslot(body.get("timeslot"));
        venue.setFlowers(body.get("flowers"));
        venue.setStage(body.get("stage"));
        venue.setDecoration(body.get("decoration"));
        venue.setImageUrl(body.get("image_url"));
        eventRepository.save(venue);
        logger.info("New venue created successfully");
        return venue;
    }
}
