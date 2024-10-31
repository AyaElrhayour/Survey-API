package com.youcode.survey.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique=true)
    @NotBlank(message = "The title can't be blank")
    private String title;

    @Column
    private String description;
}
