package com.youcode.survey.mappers;

import com.youcode.survey.models.dto.Answer.AnswerCreatingDTO;
import com.youcode.survey.models.dto.Answer.AnswerOnlyDTO;
import com.youcode.survey.models.entities.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer toAnswer(AnswerCreatingDTO AnswerCreatingDTO);
    AnswerCreatingDTO toAnswerCreatingDTO(Answer Answer);
    AnswerOnlyDTO toAnswerOnlyDTO(Answer Answer);
}
