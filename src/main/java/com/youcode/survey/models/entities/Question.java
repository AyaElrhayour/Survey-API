package com.youcode.survey.models.entities;


import com.youcode.survey.models.enums.Type;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private String text;

    @Column
    private Type type;

    @Column
    private int answerCount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Subject subject;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private Set<Answer> answers;
}
