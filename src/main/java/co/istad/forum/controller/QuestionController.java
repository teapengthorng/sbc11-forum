package co.istad.forum.controller;

import co.istad.forum.dto.*;
import co.istad.forum.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{slug}/answers")
    void createAnswer(
//            @PathVariable String answers,
            @PathVariable String slug,
            @RequestBody CreateAnswerRequest createAnswerRequest) {
        questionService.createAnswer( slug, createAnswerRequest);
    }

    @PutMapping("/{slug}/{createdBy}")
    QuestionResponse updateQuestion(@PathVariable String slug,
                                    @PathVariable String createdBy,
                                    @RequestBody QuestionUpdateViewCount questionUpdateViewCount) {
        return  questionService.viewCount(slug, createdBy, questionUpdateViewCount);
    }

    @PutMapping("/{slug}")
    QuestionResponse updateQuestion(@PathVariable String slug,
                                    @RequestBody UpdateQuestionRequest updateQuestionRequest) {
        return  questionService.updateBySlug(slug, updateQuestionRequest);
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    void createNew(@RequestBody CreateQuestionRequest createQuestionRequest) {
//        questionService.createNew(createQuestionRequest);
//    }

    @GetMapping
    List<QuestionResponse> findAll(){
        return questionService.findAll();
    }

    @GetMapping("/{slug}")
    QuestionDetailResponse findBySlug(@PathVariable String slug){
        return questionService.findBySlug(slug);
    }
}
