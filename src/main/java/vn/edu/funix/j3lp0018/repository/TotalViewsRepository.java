package vn.edu.funix.j3lp0018.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.edu.funix.j3lp0018.entity.TotalViews;

public interface TotalViewsRepository extends JpaRepository<TotalViews, Integer> {
    // Custom query to increment the view count efficiently
    @Modifying @Query("UPDATE TotalViews v SET v.viewCount = v.viewCount + 1 WHERE v.id = 1")
    void incrementViewCount();
}
