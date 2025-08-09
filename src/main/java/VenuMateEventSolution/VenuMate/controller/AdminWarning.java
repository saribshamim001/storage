package VenuMateEventSolution.VenuMate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminWarning {
    @GetMapping("/admin-cannot-book")
    public String adminCannotBookPage() {
        return "admin-cannot-book"; // refers to admin-cannot-book.html in templates
    }

}