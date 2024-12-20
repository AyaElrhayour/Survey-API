package com.youcode.survey.mappers;


import com.youcode.survey.models.dto.Question.QuestionCreatingDTO;
import com.youcode.survey.models.dto.Question.QuestionOnlyDTO;
import com.youcode.survey.models.dto.Question.QuestionReadingDTO;
import com.youcode.survey.models.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(source = "answersCount" , target = "answersCount")
    Question toQuestion(QuestionCreatingDTO questionCreatingDTO);
    @Mapping(source = "subject.id" , target = "subjectId")
    QuestionCreatingDTO toQuestionCreatingDTO(Question question);
    QuestionReadingDTO toQuestionReadingDTO(Question question);
    QuestionOnlyDTO toQuestionOnlyDTO(Question question);


}
