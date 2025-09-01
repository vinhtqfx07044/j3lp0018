package vn.edu.funix.j3lp0018.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PostOverviewDTO {
    private Integer id;
    private String title;
    private LocalDate createdAt;
    private Integer numLikes;
    private Integer numComments;
}