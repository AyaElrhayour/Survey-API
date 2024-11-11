package com.youcode.survey.models.dto.Subject;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreatingDTO {

    private UUID id;

    @NotBlank
    private String title;

    @Nullable
    private UUID parentId;

    private UUID surveyEditionId;
}
