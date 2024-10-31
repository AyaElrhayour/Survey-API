package com.youcode.survey.models.entities;


import com.youcode.survey.models.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
