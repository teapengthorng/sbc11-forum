package co.istad.forum.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record QuestionDetailResponse(
        String slug,
        String title,
        String description,
        Long viewCount,
        List<AnswerResponse>answers,
        LocalDate createdAt,
        String createdBy
) {
}
