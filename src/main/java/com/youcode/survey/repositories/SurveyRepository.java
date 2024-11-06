package com.youcode.survey.repositories;

import com.youcode.survey.models.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {

    Optional<Survey> findByTitle(String title);
    boolean existsByTitle(String title);
}
