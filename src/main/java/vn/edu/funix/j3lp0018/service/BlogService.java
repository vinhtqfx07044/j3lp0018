package vn.edu.funix.j3lp0018.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.funix.j3lp0018.entity.AboutMe;
import vn.edu.funix.j3lp0018.entity.Post;
import vn.edu.funix.j3lp0018.entity.Social;
import vn.edu.funix.j3lp0018.repository.AboutMeRepository;
import vn.edu.funix.j3lp0018.repository.PostRepository;
import vn.edu.funix.j3lp0018.repository.SocialRepository;

import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;
import vn.edu.funix.j3lp0018.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final PostRepository postRepository;
    private final AboutMeRepository aboutMeRepository;
    private final SocialRepository socialRepository;

    @Value("${blog.posts.homepage-count:4}")
    private int homepageCount;

    public List<Post> getHomepagePosts() {
        var pageable = PageRequest.of(0, homepageCount);
        return postRepository.findByOrderByCreatedAtDesc(pageable);
    }

    public Post getPostById(int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    public Map<String, List<Post>> getGroupedPosts() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        // Use Java Stream API to group posts by "MONTH YYYY"
        return posts.stream()
                .collect(Collectors.groupingBy(
                        post -> post.getCreatedAt().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                                .toUpperCase()
                                + " " + post.getCreatedAt().getYear(),
                        LinkedHashMap::new, // Keep insertion order
                        Collectors.toList()));
    }

    public AboutMe getAboutMe() {
        return aboutMeRepository.findById(1)
                .orElse(new AboutMe()); // Return an empty entity if not found
    }

    public List<Social> getSocials() {
        return socialRepository.findAll();
    }
}
