package com.youcode.survey.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEdition {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate Year;

}
