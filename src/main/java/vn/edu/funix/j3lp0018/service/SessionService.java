package vn.edu.funix.j3lp0018.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionService {

    private final ViewCounterService viewCounterService;

    public void handleNewSession(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // Check if this is a new session
        if (session.isNew()) {
            log.info("New session created: {}. Incrementing view count.", session.getId());
            try {
                int currentViews = viewCounterService.incrementAndGetViews();
                log.info("Total views are now: {}", currentViews);
            } catch (Exception e) {
                log.error("Could not increment view count for new session.", e);
            }
        }
    }
}