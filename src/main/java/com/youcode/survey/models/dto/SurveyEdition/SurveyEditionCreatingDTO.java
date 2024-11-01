package com.youcode.survey.models.dto.SurveyEdition;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyEditionCreatingDTO {

    @NotNull
    private LocalDateTime creationDate;

    @NotNull
    private LocalDate startDate;

    @Positive
    @NotNull
    private Integer year;

    @NotNull
    private UUID surveyId;

}
