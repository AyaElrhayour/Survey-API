package com.youcode.survey.models.dto.Subject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectOnlyDTO {

    private UUID id;
    private String title;
}
