package com.youcode.survey.models.dto.Subject;


import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionOnlyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDTO {

    private UUID id;
    private String title;
    private SurveyEditionOnlyDTO surveyEditionOnlyDTO;
    private List<SubjectOnlyDTO> children;
}
