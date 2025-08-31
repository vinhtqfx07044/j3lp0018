package vn.edu.funix.j3lp0018.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.funix.j3lp0018.entity.TotalViews;
import vn.edu.funix.j3lp0018.repository.TotalViewsRepository;

@Service
@RequiredArgsConstructor
public class ViewCounterService {

    private final TotalViewsRepository totalViewsRepository;

    @Transactional
    public synchronized int incrementAndGetViews() {
        totalViewsRepository.incrementViewCount();
        return totalViewsRepository.findById(1)
                .map(TotalViews::getViewCount)
                .orElse(0); // Return 0 if somehow the record is missing
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
