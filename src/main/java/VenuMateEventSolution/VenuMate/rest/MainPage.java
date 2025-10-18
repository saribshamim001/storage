package VenuMateEventSolution.VenuMate.rest;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import VenuMateEventSolution.VenuMate.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse<List<VenuesList>>> listVenues(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size) {

        Page<VenuesList> venuesPage = eventRepository.findAll(PageRequest.of(page, size));

        ApiResponse<List<VenuesList>> response = new ApiResponse<>(
                "Successfully retrieved venues",
                200,
                venuesPage.getContent(),
                venuesPage.getNumber(),
                venuesPage.getTotalPages(),
                venuesPage.getTotalElements()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/Venue/{id}")
    public ResponseEntity<ApiResponse<VenuesList>> getVenue(@PathVariable Integer id) {
        Optional<VenuesList> venue = eventRepository.findById(id);
        if (venue.isPresent()) {
            ApiResponse<VenuesList> response = new ApiResponse<>(
                    "Venue found successfully",
                    200,
                    venue.get()
            );
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<VenuesList> response = new ApiResponse<>(
                    "Venue not found",
                    404,
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
