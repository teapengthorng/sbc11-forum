package co.istad.forum.dto;

import java.util.List;

public record CreateAnswerRequest(
        String content,
        String createdBy
) {
}
