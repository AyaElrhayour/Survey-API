package com.youcode.survey.repositories;

import com.youcode.survey.models.entities.SurveyEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, UUID> {
}
