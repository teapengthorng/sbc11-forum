package co.istad.forum.dto;

import java.util.List;

public record CreateQuestionRequest(
        String slug,
        String title,
        String description,
        List<AnswerResponse> answers,
        String createdBy
) {
}
