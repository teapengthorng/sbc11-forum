package co.istad.forum.service;

import co.istad.forum.dto.*;

import java.util.List;


public interface QuestionService {
    //create new answer content and createdBy
    void createAnswer(String slug, CreateAnswerRequest createAnswerRequest);

    //Update viewcount
    QuestionResponse viewCount(String slug, String createdBy, QuestionUpdateViewCount questionUpdateViewCount);

    //Update
    QuestionResponse updateBySlug(String slug, UpdateQuestionRequest updateQuestionRequest);

    //Create a new question
    void createNew(CreateQuestionRequest createQuestionRequest);

    //find a question by slug
    QuestionDetailResponse findBySlug(String slug);

    //find all question
    List<QuestionResponse>findAll();
}
