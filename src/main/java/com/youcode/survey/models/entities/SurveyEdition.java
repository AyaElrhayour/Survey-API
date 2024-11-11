package com.youcode.survey.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "surveyEdition")
public class SurveyEdition {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDate startDate;

    @Column
    private int Year;

    @OneToMany(mappedBy = "surveyEdition" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

}
