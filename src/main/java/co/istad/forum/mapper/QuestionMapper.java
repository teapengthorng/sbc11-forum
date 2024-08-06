package co.istad.forum.mapper;

import co.istad.forum.dto.*;
import co.istad.forum.model.Answer;
import co.istad.forum.model.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Answer fromCreateAnswerRequest(CreateAnswerRequest createAnswerRequest);

    QuestionUpdateViewCount toQuestionUpdateViewCount(Question question);

    //Way 2
//    List<QuestionResponse> toQuestionResponseList(List<Question> questions);

    //Target Source (Return Type) =?
    //Main Source  (Parameter) =?
    //Way1
    QuestionResponse toQuestionResponse(Question question);

    QuestionDetailResponse toQuestionDetailResponse(Question question);

    Question fromCreateQuestion(CreateQuestionRequest createQuestionRequest);
}
