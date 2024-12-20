package com.youcode.survey.models.dto.Question;


import com.youcode.survey.models.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreatingDTO {

    private UUID id;

    @NotBlank
    private String text;

    private Type type;

    @NotNull
    private int answersCount;

    @NotNull
    private UUID subjectId;
}
