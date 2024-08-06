package co.istad.forum.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private Integer id;
    private String title;
    private String slug;
    private String description;
    private Long viewCount;
    private LocalDate createdAt;
    private String createdBy;

    // Relationship with answers
    private List<Answer> answers;
}
