package com.youcode.survey.models.dto.Owner;


import com.youcode.survey.models.dto.Survey.SurveyReadingEmbdDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerReadingEmbdDTO {

    private UUID id;
    private String name;
    private List<SurveyReadingEmbdDTO> surveys;
}
