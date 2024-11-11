package com.youcode.survey.models.dto.Survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyOnlyDTO {

    private UUID id;
    private String title;
    private String description;
}
