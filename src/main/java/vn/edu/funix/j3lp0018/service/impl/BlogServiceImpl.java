package vn.edu.funix.j3lp0018.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.edu.funix.j3lp0018.dto.PostOverviewDTO;
import vn.edu.funix.j3lp0018.dto.PostHomeDTO;
import vn.edu.funix.j3lp0018.dto.PostDetailDTO;
import vn.edu.funix.j3lp0018.entity.AboutMe;
import vn.edu.funix.j3lp0018.entity.Post;
import vn.edu.funix.j3lp0018.entity.Social;
import vn.edu.funix.j3lp0018.repository.AboutMeRepository;
import vn.edu.funix.j3lp0018.repository.PostRepository;
import vn.edu.funix.j3lp0018.repository.SocialRepository;
import vn.edu.funix.j3lp0018.service.BlogService;

import java.sql.Date;
import java.util.*;
import vn.edu.funix.j3lp0018.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final PostRepository postRepository;
    private final AboutMeRepository aboutMeRepository;
    private final SocialRepository socialRepository;

    @Value("${blog.posts.homepage-count:4}")
    private int homepageCount;

    public List<PostHomeDTO> getHomepagePosts() {
        var pageable = PageRequest.of(0, homepageCount);
        List<Post> posts = postRepository.findByOrderByCreatedAtDesc(pageable);
        return posts.stream().map(this::mapToPostHomeDTO).toList();
    }

    public PostDetailDTO getPostById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return mapToPostDetailDTO(post);
    }

    public Map<String, List<PostOverviewDTO>> getGroupedPosts() {
        List<Object[]> results = postRepository.findPostsGroupedByMonthYear();
        Map<String, List<PostOverviewDTO>> groupedPosts = new LinkedHashMap<>();

        for (Object[] row : results) {
            String groupKey = (String) row[0];
            PostOverviewDTO dto = mapToPostOverviewDTO(row);
            groupedPosts.computeIfAbsent(groupKey, k -> new ArrayList<>()).add(dto);
        }

        return groupedPosts;
    }

    public AboutMe getAboutMe() {
        return aboutMeRepository.findById(1)
                .orElse(new AboutMe()); // Return an empty entity if not found
    }

    public List<Social> getSocials() {
        return socialRepository.findAll();
    }

    private PostHomeDTO mapToPostHomeDTO(Post post) {
        PostHomeDTO dto = new PostHomeDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setType(post.getType());
        dto.setImagePath(post.getImagePath());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
    }

    private PostDetailDTO mapToPostDetailDTO(Post post) {
        PostDetailDTO dto = new PostDetailDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setImagePath(post.getImagePath());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setNumLikes(post.getNumLikes());
        dto.setNumComments(post.getNumComments());
        return dto;
    }

    private PostOverviewDTO mapToPostOverviewDTO(Object[] row) {
        Integer id = (Integer) row[1];
        String title = (String) row[2];
        Date createdAtSql = (Date) row[3];
        Integer numLikes = (Integer) row[4];
        Integer numComments = (Integer) row[5];

        PostOverviewDTO dto = new PostOverviewDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setCreatedAt(createdAtSql.toLocalDate());
        dto.setNumLikes(numLikes);
        dto.setNumComments(numComments);
        return dto;
    }
}
