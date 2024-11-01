package com.youcode.survey.repositories;

import com.youcode.survey.models.entities.SurveyEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, UUID> {
}
