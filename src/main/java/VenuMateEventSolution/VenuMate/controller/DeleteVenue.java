package VenuMateEventSolution.VenuMate.controller;
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


    @Autowired
    EventRepository eventRepository;


    @DeleteMapping("deleteVenue/{id}")
    public String deleteRecord(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<VenuesList> venueOpt = eventRepository.findById(id);

        if (venueOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Venue with ID " + id + " not found.");
            return "redirect:/venues";
        }

        try {
            eventRepository.deleteById(id);
            if (eventRepository.existsById(id)) {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete venue with ID " + id);
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Venue deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred while deleting venue.");
        }

        return "redirect:/venues"; // Change if you want a different post-delete landing page
    }

}
