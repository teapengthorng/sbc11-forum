//package co.istad.forum.service.Impl;
//
//import co.istad.forum.dto.AnswerResponse;
//import co.istad.forum.model.Answer;
//import co.istad.forum.repository.AnswerRepository;
//import co.istad.forum.service.AnswerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AnswerServiceImpl implements AnswerService {
//
//    private final AnswerRepository answerRepository;
//
//    @Override
//    public List<AnswerResponse> findAll() {
//        List<Answer> answers = answerRepository.selectAll();
//
//        return answers.stream()
//                .map(answer -> new AnswerResponse(
//                        answer.getContent(),
////                        answer.getSlug(),
//                        answer.getIsAccepted(),
//                        answer.getCreatedAt(),
//                        answer.getCreatedBy()
//
//
//                )).toList();
//    }
//}
