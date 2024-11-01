package com.youcode.survey.models.dto.Owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerReadingDTO {

    private UUID id;
    private String name;

}
