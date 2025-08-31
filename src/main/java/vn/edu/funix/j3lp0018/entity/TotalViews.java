package vn.edu.funix.j3lp0018.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "total_views")
public class TotalViews {
    @Id
    private int id;

    @Column(name = "view_count")
    private int viewCount;
}
