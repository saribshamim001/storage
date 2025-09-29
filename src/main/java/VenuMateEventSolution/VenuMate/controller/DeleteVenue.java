package VenuMateEventSolution.VenuMate.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class DeleteVenue {

    private static final Logger logger = LoggerFactory.getLogger(DeleteVenue.class);
    @Autowired
    EventRepository eventRepository;
    @DeleteMapping("deleteVenue/{id}")
    public String deleteRecord(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<VenuesList> venueOpt = eventRepository.findById(id);
        if (venueOpt.isEmpty()) {
            logger.error("Venue not found");
            redirectAttributes.addFlashAttribute("errorMessage", "Venue with ID " + id + " not found.");
            return "redirect:/venues";
        }

        try {
            eventRepository.deleteById(id);
            if (eventRepository.existsById(id)) {
                logger.error("Failed to delete venue");
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete venue with ID " + id);
            } else {
                logger.info("Venue deleted successfully");
                redirectAttributes.addFlashAttribute("successMessage", "Venue deleted successfully!");
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting venue");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred while deleting venue.");
        }

        return "redirect:/venues"; // Change if you want a different post-delete landing page
    }

}
