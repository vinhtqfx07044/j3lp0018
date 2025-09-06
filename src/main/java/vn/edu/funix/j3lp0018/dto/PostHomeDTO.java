package vn.edu.funix.j3lp0018.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PostHomeDTO {
    private Integer id;
    private String title;
    private String type;
    private String imagePath;
    private String content;
    private LocalDate createdAt;
}