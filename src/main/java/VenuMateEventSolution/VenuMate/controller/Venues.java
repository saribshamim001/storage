package VenuMateEventSolution.VenuMate.controller;
import VenuMateEventSolution.VenuMate.model.Users;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.services.VenueService;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Venues {

    private final VenueService venueService;
    public Venues(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping("/venues")
    public String venuesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            Model model,
            HttpSession session) {
            Page<VenuesList> venuesPage = venueService.getAllVenues(PageRequest.of(page, size));
            model.addAttribute("venuesPage", venuesPage);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", venuesPage.getTotalPages());
            return "venues";
    }
}