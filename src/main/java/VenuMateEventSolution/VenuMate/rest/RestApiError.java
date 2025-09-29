package VenuMateEventSolution.VenuMate.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestApiError {
    @GetMapping("/api/test-rest-error")
    public ResponseEntity<String> testRestError() {
        // Throw an exception that will be caught by RestExceptionHandler
        throw new IllegalArgumentException("Bad request for REST testing");
    }
}
