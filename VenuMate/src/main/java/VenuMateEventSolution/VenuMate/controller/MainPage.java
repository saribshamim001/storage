package VenuMateEventSolution.VenuMate.controller;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainPage {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/listOfVenues")
    public List<VenuesList> listOfVenues(){
        return eventRepository.findAll();
    }

    @GetMapping("/Venue/{id}")
    public ResponseEntity<VenuesList> getVenue(@PathVariable Integer id) {
        Optional<VenuesList> venue = eventRepository.findById(id);
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
        return venue;
    }

}
