package VenuMateEventSolution.VenuMate.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LandingPage {
    @GetMapping("/venumate.com")
    public String loginPage() {
        return "login";
    }
}
