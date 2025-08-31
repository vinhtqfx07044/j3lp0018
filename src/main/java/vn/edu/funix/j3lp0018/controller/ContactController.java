package vn.edu.funix.j3lp0018.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.funix.j3lp0018.entity.ContactMessage;
import vn.edu.funix.j3lp0018.service.BlogService;
import vn.edu.funix.j3lp0018.service.ContactService;
import vn.edu.funix.j3lp0018.service.ViewCounterService;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final BlogService blogService;
    private final ViewCounterService viewCounterService;

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        if (!model.containsAttribute("contactMessage")) {
            model.addAttribute("contactMessage", new ContactMessage());
        }
        model.addAttribute("socials", blogService.getSocials());
        model.addAttribute("viewCounter", viewCounterService.getFormattedViewsArray());
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(@ModelAttribute ContactMessage contactMessage, RedirectAttributes redirectAttributes) {
        contactService.saveMessage(contactMessage);
        redirectAttributes.addFlashAttribute("successMessage", "Thank you for your message.");
        return "redirect:/contact";
    }
}
