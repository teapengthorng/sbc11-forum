package co.istad.forum.repository;

import co.istad.forum.model.Answer;
import co.istad.forum.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {
    private final List<Answer> answers;
    public List<Answer> selectAll() {
        return answers;
    }
}
