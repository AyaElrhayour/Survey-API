package com.youcode.survey.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "survey")
public class Survey {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(unique=true)
    @NotBlank(message = "The title can't be blank")
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyEdition> surveyEditions;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Owner owner;
}
