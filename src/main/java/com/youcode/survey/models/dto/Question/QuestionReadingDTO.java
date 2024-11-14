package com.youcode.survey.models.dto.Question;

import com.youcode.survey.models.dto.Answer.AnswerOnlyDTO;
import com.youcode.survey.models.dto.Subject.SubjectOnlyDTO;
import com.youcode.survey.models.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionReadingDTO {

    private UUID id;
    private Type type;
    private String text;
    private Integer answerCount;
    private SubjectOnlyDTO subject;
    private List<AnswerOnlyDTO> answerList;
}
