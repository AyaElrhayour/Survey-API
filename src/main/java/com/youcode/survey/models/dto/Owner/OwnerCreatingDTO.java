package com.youcode.survey.models.dto.Owner;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerCreatingDTO {

    @NotBlank(message = "The name can't be empty ")
    private String name;
}
