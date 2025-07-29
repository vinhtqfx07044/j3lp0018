package vn.edu.funix.j3lp0018.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.funix.j3lp0018.service.BlogService;

 @Controller @RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    // A helper method to add common attributes to the model
    private void addCommonAttributes(Model model) {
        model.addAttribute("socials", blogService.getSocials());
    }

    @GetMapping({"/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("posts", blogService.getHomepagePosts());
        addCommonAttributes(model);
        return "home"; // Returns templates/home.html
    }

    @GetMapping("/post/{id}")
    public String showPostDetailPage( @PathVariable int id, Model model) {
        model.addAttribute("post", blogService.getPostById(id));
        addCommonAttributes(model);
        return "post-detail"; // Returns templates/post-detail.html
    }

    @GetMapping("/overview")
    public String showOverviewPage(Model model) {
        model.addAttribute("groupedPosts", blogService.getGroupedPosts());
        addCommonAttributes(model);
        return "overview"; // Returns templates/overview.html
    }
}
