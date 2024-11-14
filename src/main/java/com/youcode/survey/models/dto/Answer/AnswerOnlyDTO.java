package com.youcode.survey.models.dto.Answer;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerOnlyDTO {

    private UUID id;
    private String text;
    private Integer selectionCount;
}
