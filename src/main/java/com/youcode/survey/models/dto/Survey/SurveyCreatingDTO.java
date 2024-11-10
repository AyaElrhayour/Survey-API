package com.youcode.survey.models.dto.Survey;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyCreatingDTO {

    private UUID id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Positive
    @NotNull
    private UUID ownerId;

}
