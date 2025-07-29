package vn.edu.funix.j3lp0018.listener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vn.edu.funix.j3lp0018.service.ViewCounterService;

 @Slf4j // Lombok annotation for logging
 @Component // Mark this as a Spring component
 @RequiredArgsConstructor
public class SessionListener implements HttpSessionListener {

    private final ViewCounterService viewCounterService;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("New session created. Incrementing view count.");
        try {
            int currentViews = viewCounterService.incrementAndGetViews();
            log.info("Total views are now: {}", currentViews);

            // Format the count as a 6-digit string (e.g., 039918)
            String formattedCount = String.format("%06d", currentViews);
            String[] countArray = formattedCount.split("");

            // Store the character array in the session for the footer to display
            HttpSession session = se.getSession();
            session.setAttribute("viewCounter", countArray);

        } catch (Exception e) {
            log.error("Could not increment and update view count in session.", e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session destroyed.");
    }
}
