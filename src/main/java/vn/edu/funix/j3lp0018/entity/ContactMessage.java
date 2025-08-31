package vn.edu.funix.j3lp0018.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_message")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @Column(length = 1000)
    private String message;
}