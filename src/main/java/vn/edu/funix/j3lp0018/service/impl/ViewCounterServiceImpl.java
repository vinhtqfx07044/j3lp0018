package vn.edu.funix.j3lp0018.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.funix.j3lp0018.entity.TotalViews;
import vn.edu.funix.j3lp0018.repository.TotalViewsRepository;
import vn.edu.funix.j3lp0018.service.ViewCounterService;

@Service
@RequiredArgsConstructor
public class ViewCounterServiceImpl implements ViewCounterService {

    private final TotalViewsRepository totalViewsRepository;

    @Transactional
    public int incrementAndGetViews() {
        try {
            // Use atomic database operation with PostgreSQL RETURNING clause
            Integer newCount = totalViewsRepository.incrementAndGetViewCount();
            return (newCount != null) ? newCount : 0;
        } catch (Exception e) {
            // Fallback to old method if atomic operation fails
            return getCurrentViews();
        }
    }

    public int getCurrentViews() {
        return totalViewsRepository.findById(1)
                .map(TotalViews::getViewCount)
                .orElse(0);
    }

    public String[] getFormattedViewsArray() {
        int currentViews = getCurrentViews();
        String formattedCount = String.format("%06d", currentViews);
        return formattedCount.split("");
    }
}
