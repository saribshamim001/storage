package VenuMateEventSolution.VenuMate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class error {

    @GetMapping("/error")
    public String bookingPage(){
        return "error";
    }

    @GetMapping("/test-mvc-error")
    public String testMvcError() {
        throw new RuntimeException("Something broke in MVC controller");
    }

}
