package com.youcode.survey.models.dto.SurveyEdition;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyEditionOnlyDTO {

    private UUID id;
    private LocalDateTime creationDate;
    private LocalDate startDate;
    private Integer year;
}
