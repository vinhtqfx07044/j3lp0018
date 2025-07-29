package vn.edu.funix.j3lp0018.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.funix.j3lp0018.dto.ContactDto;
import vn.edu.funix.j3lp0018.service.BlogService;
import vn.edu.funix.j3lp0018.service.ContactService;

 @Controller @RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final BlogService blogService;

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        // Add a new ContactDto to the model for form binding
        if (!model.containsAttribute("contactDto")) {
            model.addAttribute("contactDto", new ContactDto());
        }
        model.addAttribute("socials", blogService.getSocials());
        return "contact"; // Returns templates/contact.html
    }

    @PostMapping("/contact")
    public String handleContactForm( @ModelAttribute ContactDto contactDto, RedirectAttributes redirectAttributes) {
        // Here you can add validation logic if needed
        contactService.saveMessage(contactDto);
        redirectAttributes.addFlashAttribute("successMessage", "Thank you for your message.");
        return "redirect:/contact"; // Redirect to prevent form resubmission
    }
}
