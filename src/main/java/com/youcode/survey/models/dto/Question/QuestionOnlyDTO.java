package com.youcode.survey.models.dto.Question;


import com.youcode.survey.models.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOnlyDTO {

    private UUID id;

    private Type type;

    private String text;

    private int answersCount;
}
