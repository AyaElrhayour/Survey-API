package com.youcode.survey.models.dto.Subject;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreatingDTO {

    @NotBlank
    private String title;

    private UUID parentId;

    private UUID surveyEditionId;
}
