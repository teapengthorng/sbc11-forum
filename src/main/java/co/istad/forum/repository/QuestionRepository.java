package co.istad.forum.repository;

import co.istad.forum.model.Answer;
import co.istad.forum.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final List<Question> questions;
    private final List<Answer> answers;

    public Answer updateanswer(Answer newANswer) {
        return questions.stream()
                .filter(q-> q.getSlug().equals(newANswer.getSlug()))
                .map(q-> newANswer)
                .findFirst()
                .orElseThrow();
    }

    public void answerInsert(Answer answer){
        answers.add(answer);
    }

    public Question updateviewCount(Question newQuestion) {
        return questions.stream()
                .filter(q-> q.getSlug().equals(newQuestion.getSlug()))
                .filter(q-> q.getCreatedBy().equals(newQuestion.getCreatedBy()))
                .map(q-> newQuestion)
                .findFirst()
                .orElseThrow();
    }

    public Question update(Question newQuestion) {
      return questions.stream()
                .filter(q-> q.getSlug().equals(newQuestion.getSlug()))
                .map(q-> newQuestion)
                .findFirst()
              .orElseThrow();
    }

    public void insert(Question question){
        questions.add(question);
    }

    public List<Question> selectAll() {
        return questions;
    }

    public Integer cout(){
        return questions.size();
    }
}
