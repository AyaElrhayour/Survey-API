package com.youcode.survey.models.dto.Answer;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreatingDTO {

    @NotBlank
    private String text;

    @NotNull
    private Integer selectionCount = 0;

    @NotNull
    private UUID questionId;
}
