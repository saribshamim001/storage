package VenuMateEventSolution.VenuMate.exceptions;
import VenuMateEventSolution.VenuMate.rest.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(basePackages = "VenuMateEventSolution.VenuMate.rest")
public class RestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    // 400 - Bad Request
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleBadRequest(IllegalArgumentException ex, WebRequest request) {
        logger.error("Bad request: {}", ex.getMessage(), ex);
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request, something is wrong with the input",
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // 500 - Database error
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiError> handleDatabaseError(DataAccessException ex, WebRequest request) {
        logger.error("Database error: {}", ex.getMessage(), ex);
        ApiError error = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Database Error",
                "Database is currently unavailable. Please try again later.",
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    // 502 - SMS sending error
    @ExceptionHandler(SmsSendingException.class)
    public ResponseEntity<ApiError> handleSmsError(SmsSendingException ex, WebRequest request) {
        logger.error("SMS error: {}", ex.getMessage(), ex);
        ApiError error = new ApiError(
                HttpStatus.BAD_GATEWAY.value(),
                "SMS Service Error",
                "Booking saved, but SMS could not be sent.",
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }

    // Fallback - 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericError(Exception ex, WebRequest request) {
        logger.error("Unexpected error: {}", ex.getMessage(), ex);
        ApiError error = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Something went wrong. Please try again later.",
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}