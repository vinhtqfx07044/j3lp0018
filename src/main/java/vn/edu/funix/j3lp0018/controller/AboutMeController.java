package vn.edu.funix.j3lp0018.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.funix.j3lp0018.service.BlogService; // Reusing BlogService for getAboutMe and getSocials

 @Controller @RequiredArgsConstructor
public class AboutMeController {

    private final BlogService blogService;

    @GetMapping("/about-me")
    public String showAboutMePage(Model model) {
        model.addAttribute("aboutMe", blogService.getAboutMe());
        model.addAttribute("socials", blogService.getSocials());
        return "about-me"; // Returns templates/about-me.html
    }
}
