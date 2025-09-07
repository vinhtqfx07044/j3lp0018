package vn.edu.funix.j3lp0018.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.funix.j3lp0018.dto.ContactMessageRequestDTO;
import vn.edu.funix.j3lp0018.service.ContactService;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("contactMessage", new ContactMessageRequestDTO());
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(
            @Valid @ModelAttribute ContactMessageRequestDTO contactMessage,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("contactMessage", contactMessage);
            model.addAttribute("org.springframework.validation.BindingResult.contactMessage", bindingResult);
            return "contact";
        }

        contactService.saveMessage(contactMessage);
        redirectAttributes.addFlashAttribute("successMessage", "Thank you for your message.");
        return "redirect:/contact";
    }
}
