package co.istad.forum.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    private Integer id;
    private String uuid;
    private String content;
    private String slug;
    private Boolean isAccepted;
    private LocalDate createdAt;
    private String createdBy;

    // Relationship with question
    private Question question;
}
