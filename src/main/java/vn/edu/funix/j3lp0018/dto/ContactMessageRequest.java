package vn.edu.funix.j3lp0018.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactMessageRequest {
    
    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 100, message = "Name must not exceed 100 characters.")
    private String name;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Please provide a valid email format.")
    @Size(max = 100, message = "Email must not exceed 100 characters.")
    private String email;

    @NotBlank(message = "Message cannot be empty.")
    @Size(max = 1000, message = "Message must not exceed 1000 characters.")
    private String message;
}