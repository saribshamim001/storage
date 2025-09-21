package VenuMateEventSolution.VenuMate.controller;

import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Controller
public class UpdateVenue {

    private static final Logger logger = LoggerFactory.getLogger(UpdateVenue.class);

    @Autowired
    EventRepository eventRepository;


    @GetMapping("/updateVenue")
    public String showUpdateForm(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("venueId", id);
        return "update-venue";
    }


    @PutMapping("/updateVenue/{id}")
    public String updateVenue(@PathVariable Integer id,
                              @RequestParam("name") String name,
                              @RequestParam("capacity") int capacity,
                              @RequestParam("timeslot") String timeslot,
                              @RequestParam("decoration") String decoration,
                              @RequestParam("stage") String stage,
                              @RequestParam("flowers") String flowers,
                              @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
                              RedirectAttributes redirectAttributes) {

        VenuesList venue = eventRepository.findById(id).orElseThrow();

        venue.setName(name);
        venue.setCapacity(capacity);
        venue.setTimeslot(timeslot);
        venue.setDecoration(decoration);
        venue.setStage(stage);
        venue.setFlowers(flowers);

        if (imageFile != null && !imageFile.isEmpty()) {
            String uploadDir = Paths.get(System.getProperty("user.dir"), "uploaded-images").toString();
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) uploadFolder.mkdirs();

            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);

            try {
                // Validate filename
                if (fileName == null || fileName.isEmpty()) {
                    logger.error("Invalid file name");
                    redirectAttributes.addFlashAttribute("errorMessage", "Invalid file name.");
                    return "update-venue"; // Adjust to your update form template if needed
                }

                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Save relative path to DB for frontend access
                String imageUrl = "images/" + fileName;
                venue.setImageUrl(imageUrl);

            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Failed to upload image");
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to upload image.");
                return "update-venue"; // Adjust to your update form template if needed
            }
        }

        eventRepository.save(venue);
        redirectAttributes.addFlashAttribute("successMessage", "Venue updated successfully!");
        return "redirect:/venues";
    }

}