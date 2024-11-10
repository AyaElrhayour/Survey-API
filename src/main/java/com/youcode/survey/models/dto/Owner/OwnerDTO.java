package com.youcode.survey.models.dto.Owner;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private UUID id;

    @NotBlank(message = "The name can't be empty ")
    private String name;

}
