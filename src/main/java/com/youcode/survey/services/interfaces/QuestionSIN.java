package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Question.QuestionCreatingDTO;
import com.youcode.survey.models.dto.Question.QuestionReadingDTO;

import java.util.List;
import java.util.UUID;

public interface QuestionSIN {

    QuestionCreatingDTO createQuestion(QuestionCreatingDTO questionCreatingDTO);
    List<QuestionReadingDTO> readQuestions();
    QuestionReadingDTO findQuestionById(UUID id);
    boolean deleteQuestion(UUID id);
    QuestionCreatingDTO updateQuestion(UUID id, QuestionCreatingDTO questionReadingDTO);
}
