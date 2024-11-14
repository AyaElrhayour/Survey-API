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

    @ManyToOne
    @JoinColumn(name = "parent")
    private Subject parent;

   @OneToMany(mappedBy = "parent" , fetch = FetchType.EAGER)
   private Set<Subject> children;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Question> question;

    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyEdition surveyEdition;

}
