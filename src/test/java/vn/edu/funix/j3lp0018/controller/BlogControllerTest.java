package vn.edu.funix.j3lp0018.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import vn.edu.funix.j3lp0018.dto.ContactDto;
import vn.edu.funix.j3lp0018.dto.PostDto;
import vn.edu.funix.j3lp0018.service.BlogService;
import vn.edu.funix.j3lp0018.service.ContactService;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// We test all controllers that BlogService is injected into
 @WebMvcTest(controllers = {BlogController.class, AboutMeController.class, ContactController.class})
class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc; // The main entry point for server-side Spring MVC test support

    @MockBean // Creates a mock of BlogService and adds it to the ApplicationContext
    private BlogService blogService;

    @MockBean
    private ContactService contactService;


    @Test
    void showHomePage_shouldReturnHomePageWithPosts() throws Exception {
        // Arrange
        PostDto post1 = new PostDto();
        post1.setId(1);
        post1.setTitle("First Post");
        when(blogService.getHomepagePosts()).thenReturn(List.of(post1));

        // Act & Assert
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk()) // Expect HTTP 200 OK
                .andExpect(view().name("home")) // Expect the view name to be "home"
                .andExpect(model().attributeExists("posts")) // Expect "posts" attribute in the model
                .andExpect(model().attribute("posts", hasSize(1))); // Expect the list to have 1 item
    }

    @Test
    void showPostDetailPage_whenPostExists_shouldReturnPostDetailView() throws Exception {
        // Arrange
        PostDto post = new PostDto();
        post.setId(1);
        post.setTitle("Test Post");
        post.setCreatedAt(LocalDate.now());
        when(blogService.getPostById(1)).thenReturn(post);

        // Act & Assert
        mockMvc.perform(get("/post/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post-detail"))
                .andExpect(model().attribute("post", post));
    }

    @Test
    void handleContactForm_shouldSaveMessageAndRedirect() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/contact")
                        .param("name", "Test User")
                        .param("email", "test @user.com")
                        .param("message", "A test message"))
                .andExpect(status().is3xxRedirection()) // Expect a redirect (HTTP 302)
                .andExpect(redirectedUrl("/contact"));

        // Verify that the saveMessage method was called on the service
        verify(contactService).saveMessage(any(ContactDto.class));
    }
}
