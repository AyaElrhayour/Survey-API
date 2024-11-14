package com.youcode.survey.models.dto.Question;


import com.youcode.survey.models.enums.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreatingDTO {

    @NotBlank
    private String text;

    private Type type;


    private UUID subjectId;
}
