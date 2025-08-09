package VenuMateEventSolution.VenuMate.controller;
import VenuMateEventSolution.VenuMate.model.Users;
import VenuMateEventSolution.VenuMate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.IncorrectResultSizeDataAccessException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;                 // For HttpSession (Jakarta EE 9+)
import org.springframework.ui.Model;                     // For passing data to the view

@Controller
public class Login {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Users user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            model.addAttribute("loginError", true); // flag used in frontend
            return "login"; // stay on login page
        }

        session.setAttribute("loggedInUser", user);
        return "redirect:/venues";
    }



}
