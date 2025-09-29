package VenuMateEventSolution.VenuMate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = "VenuMateEventSolution.VenuMate.controllers")
public class GlobalMvcExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalMvcExceptionHandler.class);

    // Handle DB errors for MVC
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDatabaseError(DataAccessException ex) {
        logger.error("Database error (MVC): {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error"); // error.html
        mav.addObject("message", "Database is currently unavailable. Please try again later.");
        return mav;
    }

    // Handle unexpected errors for MVC
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericError(Exception ex) {
        logger.error("Unexpected error (MVC): {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "Oops! Something went wrong.");
        return mav;
    }


    // Handle invalid arguments (bad input from user forms)
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgument(IllegalArgumentException ex) {
        logger.warn("Invalid input: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "Invalid input provided. Please check your form values.");
        return mav;
    }

    // Handle validation errors (e.g. @Valid DTOs)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleValidationError(MethodArgumentNotValidException ex) {
        logger.warn("Validation failed: {}", ex.getMessage(), ex);
        String errorMessage = ex.getBindingResult().getAllErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .findFirst()
                .orElse("Invalid data submitted.");
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "Validation error: " + errorMessage);
        return mav;
    }

    // Handle missing parameters
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParam(MissingServletRequestParameterException ex) {
        logger.warn("Missing request parameter: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "A required parameter is missing: " + ex.getParameterName());
        return mav;
    }

    // Handle resource not found (custom exception)
    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ModelAndView handleResourceNotFound(ConfigDataResourceNotFoundException ex) {
        logger.warn("Resource not found: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "The requested resource could not be found.");
        return mav;
    }

}