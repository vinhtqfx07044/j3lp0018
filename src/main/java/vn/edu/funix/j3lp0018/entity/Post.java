package vn.edu.funix.j3lp0018.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

 @Data // Lombok's annotation to generate getters, setters, toString, etc.
 @Entity @Table(name = "post")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String type;

    @Column(name = "image_path")
    private String imagePath;

    @Column(length = 2000) // Define a larger length for content
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    // Based on the overview screenshot, we also have likes and comments
    @Column(name = "num_likes")
    private int numLikes;

    @Column(name = "num_comments")
    private int numComments;
}
