package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Answer.AnswerCreatingDTO;
import com.youcode.survey.models.dto.Answer.AnswerOnlyDTO;

import java.util.List;
import java.util.UUID;

public interface AnswerSIN {
    AnswerCreatingDTO createAnswer(AnswerCreatingDTO answer);
    List<AnswerOnlyDTO> getAnswers();
    AnswerOnlyDTO getAnswerByID(UUID id);
    boolean deleteAnswer(UUID id);
    AnswerCreatingDTO updateAnswer(UUID id, AnswerCreatingDTO answer);
}
