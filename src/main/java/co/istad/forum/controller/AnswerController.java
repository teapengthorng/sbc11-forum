//package co.istad.forum.controller;
//
//import co.istad.forum.dto.AnswerResponse;
//import co.istad.forum.dto.QuestionResponse;
//import co.istad.forum.service.AnswerService;
//import co.istad.forum.service.QuestionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/answers")
//public class AnswerController {
//    private final AnswerService answerService;
//    @GetMapping
//    List<AnswerResponse> findAll(){
//        return answerService.findAll();
//    }
//}
