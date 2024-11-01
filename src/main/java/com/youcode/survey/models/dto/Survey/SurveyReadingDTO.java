package com.youcode.survey.models.dto.Survey;


import com.youcode.survey.models.dto.Owner.OwnerReadingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyReadingDTO {


    private UUID id;
    private String title;
    private String description;
    private OwnerReadingDTO owner;


}
