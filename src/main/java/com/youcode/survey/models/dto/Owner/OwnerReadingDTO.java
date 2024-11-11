package com.youcode.survey.models.dto.Owner;


import com.youcode.survey.models.dto.Survey.SurveyOnlyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerReadingDTO {

    private UUID id;
    private String name;
    private List<SurveyOnlyDTO> surveys;
}
