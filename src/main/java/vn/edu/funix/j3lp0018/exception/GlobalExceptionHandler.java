package vn.edu.funix.j3lp0018.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

 @Slf4j @ControllerAdvice // This annotation makes it a global exception handler
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.warn("Handling ResourceNotFoundException: {}", ex.getMessage());
        ModelAndView mav = new ModelAndView("error-404"); // Target template: error-404.html
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(Exception.class) // A fallback for any other exceptions
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleGenericException(Exception ex) {
        log.error("An unexpected error occurred", ex);
        ModelAndView mav = new ModelAndView("error"); // Target template: error.html
        mav.addObject("errorMessage", "An unexpected error occurred. Please try again later.");
        return mav;
    }
}
