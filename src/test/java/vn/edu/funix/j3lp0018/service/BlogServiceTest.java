package vn.edu.funix.j3lp0018.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import vn.edu.funix.j3lp0018.dto.PostDto;
import vn.edu.funix.j3lp0018.entity.Post;
import vn.edu.funix.j3lp0018.exception.ResourceNotFoundException;
import vn.edu.funix.j3lp0018.mapper.AboutMeMapper;
import vn.edu.funix.j3lp0018.mapper.PostMapper;
import vn.edu.funix.j3lp0018.mapper.SocialMapper;
import vn.edu.funix.j3lp0018.repository.AboutMeRepository;
import vn.edu.funix.j3lp0018.repository.PostRepository;
import vn.edu.funix.j3lp0018.repository.SocialRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

 @ExtendWith(MockitoExtension.class) // Enables Mockito annotations
class BlogServiceTest {

    @Mock // Creates a mock implementation for the PostRepository
    private PostRepository postRepository;
    @Mock
    private AboutMeRepository aboutMeRepository;
    @Mock
    private SocialRepository socialRepository;

    @Mock // Creates a mock for the mapper
    private PostMapper postMapper;
    @Mock
    private AboutMeMapper aboutMeMapper;
    @Mock
    private SocialMapper socialMapper;


    @InjectMocks // Creates an instance of BlogService and injects the mocks into it
    private BlogService blogService;

    private Post post1;
    private PostDto postDto1;

    @BeforeEach
    void setUp() {
        // Prepare reusable test data
        post1 = new Post();
        post1.setId(1);
        post1.setTitle("Test Post");
        post1.setCreatedAt(LocalDate.of(2024, 8, 17));

        postDto1 = new PostDto();
        postDto1.setId(1);
        postDto1.setTitle("Test Post");
    }

    @Test
    void getPostById_whenPostExists_shouldReturnPostDto() {
        // Arrange: Define the behavior of the mocks
        when(postRepository.findById(1)).thenReturn(Optional.of(post1));
        when(postMapper.toDto(post1)).thenReturn(postDto1);

        // Act: Call the method to be tested
        PostDto foundPost = blogService.getPostById(1);

        // Assert: Check the result
        assertNotNull(foundPost);
        assertEquals(1, foundPost.getId());
        assertEquals("Test Post", foundPost.getTitle());

        // Verify that the repository and mapper methods were called
        verify(postRepository).findById(1);
        verify(postMapper).toDto(post1);
    }

    @Test
    void getPostById_whenPostDoesNotExist_shouldThrowResourceNotFoundException() {
        // Arrange
        when(postRepository.findById(99)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            blogService.getPostById(99);
        });

        // Verify that only the repository was called
        verify(postRepository).findById(99);
        verify(postMapper, never()).toDto(any());
    }

    @Test
    void getGroupedPosts_shouldReturnMapGroupedByMonthAndYear() {
        // Arrange
        Post post2 = new Post();
        post2.setId(2);
        post2.setCreatedAt(LocalDate.of(2024, 7, 15));
        List<Post> posts = List.of(post1, post2);
        
        // Mock repository call
        when(postRepository.findAll(any(Sort.class))).thenReturn(posts);
        
        // Mock mapper behavior for each post
        when(postMapper.toDto(any(Post.class))).thenAnswer(invocation -> {
            Post p = invocation.getArgument(0);
            PostDto dto = new PostDto();
            dto.setId(p.getId());
            dto.setCreatedAt(p.getCreatedAt()); // Important for grouping
            return dto;
        });

        // Act
        Map<String, List<PostDto>> groupedPosts = blogService.getGroupedPosts();

        // Assert
        assertNotNull(groupedPosts);
        assertEquals(2, groupedPosts.size()); // AUGUST 2024 and JULY 2024
        assertTrue(groupedPosts.containsKey("AUGUST 2024"));
        assertTrue(groupedPosts.containsKey("JULY 2024"));
        assertEquals(1, groupedPosts.get("AUGUST 2024").size());
    }
}
