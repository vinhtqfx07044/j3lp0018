package vn.edu.funix.j3lp0018.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PostDetailDTO {
    private Integer id;
    private String title;
    private String imagePath;
    private String content;
    private LocalDate createdAt;
    private Integer numLikes;
    private Integer numComments;
}