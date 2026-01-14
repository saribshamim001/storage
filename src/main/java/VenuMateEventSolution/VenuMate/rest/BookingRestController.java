package VenuMateEventSolution.VenuMate.rest;

import VenuMateEventSolution.VenuMate.DTO.BookedVenues;
import VenuMateEventSolution.VenuMate.repository.BookingJDBCRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingRestController {

    private static final Logger logger = LoggerFactory.getLogger(BookingRestController.class);

    @Autowired
    private BookingJDBCRepository bookingJDBCRepository;

    /**
     * REST endpoint to fetch booked venues details
     * @return List of BookedVenues DTO objects
     */
    @GetMapping("/booked-venues")
    public List<BookedVenues> getBookedVenuesDetails() {
        List<BookedVenues> bookedVenues = bookingJDBCRepository.findBookedVenuesDetails();
        logger.info("\nFetched booked venues data:\n");
        for (BookedVenues venue : bookedVenues) {
            logger.info("Id: {}, Date: {}, Name: {}",
                    venue.getBookingVenueId(),
                    venue.getBookingDate(),
                    venue.getName());
        }
        logger.info("\nEnd of booked venues list\n");
        return bookedVenues;
    }
}