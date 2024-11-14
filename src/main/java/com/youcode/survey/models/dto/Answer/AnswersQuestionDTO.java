package com.youcode.survey.models.dto.Answer;


import com.youcode.survey.models.dto.Question.QuestionOnlyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersQuestionDTO {

    private UUID id;

    private String text;

    private Integer selectionCount;

    private QuestionOnlyDTO question;
}
