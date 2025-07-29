package vn.edu.funix.j3lp0018.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.funix.j3lp0018.entity.Post;

import java.util.List;

 @Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // Spring Data JPA will automatically create a query for this method name
    // It will fetch posts and sort them by creation date in descending order
    List<Post> findByOrderByCreatedAtDesc(Pageable pageable);
}
