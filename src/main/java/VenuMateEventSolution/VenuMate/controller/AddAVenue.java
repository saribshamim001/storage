package VenuMateEventSolution.VenuMate.controller;
import VenuMateEventSolution.VenuMate.model.VenuesList;
import VenuMateEventSolution.VenuMate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddAVenue {

    private static final Logger logger = LoggerFactory.getLogger(AddAVenue.class);

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/admin/add-venue")
    public String addVenuePage(){
        return "add-venue";
    }

    @PostMapping("/admin/add-new-venue")
    public String addVenue(@RequestParam("name") String name,
                           @RequestParam("capacity") int capacity,
                           @RequestParam("timeslot") String timeslot,
                           @RequestParam("decoration") String decoration,
                           @RequestParam("stage") String stage,
                           @RequestParam("flowers") String flowers,
                           @RequestParam("imageFile") MultipartFile imageFile,
                           RedirectAttributes redirectAttributes) {

        String uploadDir = Paths.get(System.getProperty("user.dir"), "uploaded-images").toString();
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) uploadFolder.mkdirs();

        String fileName = imageFile.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);

        try {
            // Create directories if they don't exist
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

        // Get original filename
        if (fileName == null || fileName.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid file name.");
            return "add-venue";  // Return to form with error
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save relative path to DB for frontend access
        String imageUrl = "images/" + fileName;
        logger.info("Adding venue with image");
        VenuesList venue = new VenuesList();
        venue.setName(name);
        venue.setCapacity(capacity);
        venue.setTimeslot(timeslot);
        venue.setDecoration(decoration);
        venue.setStage(stage);
        venue.setFlowers(flowers);
        venue.setImageUrl(imageUrl);
        eventRepository.save(venue);
        logger.debug("Venue saved successfully: {}", venue);
        redirectAttributes.addFlashAttribute("successMessage", "Venue added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to add venue.");
            return "add-venue";
        }
        return "redirect:/venues"; // or return back to the form
    }
}