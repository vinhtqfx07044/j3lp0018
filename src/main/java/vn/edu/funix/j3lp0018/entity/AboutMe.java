package vn.edu.funix.j3lp0018.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "about_me")
public class AboutMe {
    @Id // There is only one "About Me" record, so we use a fixed ID.
    private int id;

    @Column(length = 4000)
    private String content;

    @Column(name = "image_path")
    private String imagePath;

    private String author;
}
