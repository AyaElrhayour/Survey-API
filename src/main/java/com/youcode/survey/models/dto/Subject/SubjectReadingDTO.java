package com.youcode.survey.models.dto.Subject;


import com.youcode.survey.models.dto.Survey.SurveyReadingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectReadingDTO {

    private UUID id;
    private String title;
    private SurveyReadingDTO surveyEdition;
    private SubjectParentResponseDTO parent;
}
