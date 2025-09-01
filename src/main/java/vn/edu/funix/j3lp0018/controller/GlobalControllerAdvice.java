package vn.edu.funix.j3lp0018.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.edu.funix.j3lp0018.entity.Social;
import vn.edu.funix.j3lp0018.service.BlogService;
import vn.edu.funix.j3lp0018.service.ViewCounterService;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {

    private final BlogService blogService;
    private final ViewCounterService viewCounterService;

    @ModelAttribute("socials")
    public List<Social> addSocialsToModel() {
        return blogService.getSocials();
    }

    @ModelAttribute("viewCounter")
    public String[] addViewCounterToModel() {
        return viewCounterService.getFormattedViewsArray();
    }
}