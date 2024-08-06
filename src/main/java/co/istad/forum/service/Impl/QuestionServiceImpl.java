package co.istad.forum.service.Impl;

import co.istad.forum.dto.*;
import co.istad.forum.mapper.QuestionMapper;
import co.istad.forum.model.Answer;
import co.istad.forum.model.Question;
import co.istad.forum.repository.QuestionRepository;
import co.istad.forum.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.internal.util.Collections;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    //create new answer content and createdBy

    @Override
    public void createAnswer(String slug, CreateAnswerRequest createAnswerRequest) {
        Question question = questionRepository
                .selectAll()
                .stream()
                .filter(q -> q.getSlug().equals(slug))
                .findFirst()
                .orElseThrow();

        Answer answer1 = questionMapper.fromCreateAnswerRequest(createAnswerRequest);
         answer1.setUuid("P001");
         answer1.setIsAccepted(true);
         answer1.setCreatedAt(LocalDate.now());

        // Save the answer
        questionRepository.answerInsert(answer1);
    }

    //Update viewcount
    @Override
    public QuestionResponse viewCount(String slug, String createdBy, QuestionUpdateViewCount questionUpdateViewCount) {
        Question question = questionRepository
                .selectAll()
                .stream()
                .filter(q -> q.getSlug().equals(slug))
                .findFirst()
                .orElseThrow();

        // Check if the createdBy does not match and increment the view count
        if (!question.getCreatedBy().equals(createdBy)) {
            question.setViewCount(question.getViewCount() + 1); // Increment by 1
        }

        questionRepository.update(question);
        return questionMapper.toQuestionResponse(question);
    }

    //Update
    @Override
    public QuestionResponse updateBySlug(String slug, UpdateQuestionRequest updateQuestionRequest) {
        //Check Slug, exist or not
        Question question = questionRepository
                .selectAll()
                .stream()
                .filter(q -> q.getSlug().equals(slug))
                .findFirst()
                .orElseThrow();

        //If slug exidts
        question.setDescription(updateQuestionRequest.description());

        //Save
       question = questionRepository.update(question);

        return questionMapper.toQuestionResponse(question);
    }

    //Create a new question
    @Override
    public void createNew(CreateQuestionRequest createQuestionRequest) {
        //slug validate
        boolean isExisted = questionRepository
                .selectAll()
                .stream()
                .anyMatch(question -> question.getSlug().equals(createQuestionRequest.slug()));
                if(isExisted){
                    System.out.println("Slug already exists");
                    return;
                }

              //Map DTO to Domain Model
                Question question1 = questionMapper.fromCreateQuestion(createQuestionRequest);
                question1.setId(questionRepository.cout() +1);
                question1.setCreatedAt(LocalDate.now());
                question1.setViewCount(0L);
//                question1.setAnswers(new ArrayList<>());

        // Initialize answers list and add provided answers
        List<AnswerResponse> answers = createQuestionRequest.answers() != null
                ? new ArrayList<>(createQuestionRequest.answers())
                : new ArrayList<>();

        questionRepository.insert(question1);
    }

    //find a question by slug
    //    {{api_base_uri}}/questions/run-unlimited-analysis-on-our-most-powerful-servers
    @Override
    public QuestionDetailResponse findBySlug(String slug) {
        Question question = questionRepository
                .selectAll()
                .stream()
                .filter(q -> q.getSlug().equals(slug))
                .findFirst()
                .orElseThrow();

        //Map Domain Model to DTO
        return questionMapper.toQuestionDetailResponse(question);

    }

    //find all question
//    {{api_base_uri}}/questions
    @Override
    public List<QuestionResponse> findAll() {
        List<Question> questions = questionRepository.selectAll();

        //way1
        return questions.stream()
                .map(questionMapper::toQuestionResponse).toList();

//        way2
//        return questionMapper.toQuestionResponseList(questions);
    }
}
