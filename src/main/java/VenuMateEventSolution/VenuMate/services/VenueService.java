package VenuMateEventSolution.VenuMate.services;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    private static final Logger logger = LoggerFactory.getLogger(VenueService.class);
    @Autowired
    private EventRepository eventRepository;
    public Page<VenuesList> getAllVenues(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }
}