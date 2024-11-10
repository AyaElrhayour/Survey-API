package com.youcode.survey.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
public class Subject {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Subject subject;

    //wa Aya wa flana matnsych tzidi children dyal subject rah subject wa7d y9dr ykon 3ndo bzf children xo past aya

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Question> question;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SurveyEdition surveyEdition;


}
