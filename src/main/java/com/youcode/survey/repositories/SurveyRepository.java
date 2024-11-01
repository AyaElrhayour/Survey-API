package com.youcode.survey.repositories;

import com.youcode.survey.models.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {

    Optional<Survey> findByTitle(String title);
    boolean existsByTitle(String title);
}
