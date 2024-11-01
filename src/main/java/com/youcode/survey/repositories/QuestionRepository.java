package com.youcode.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<QuestionRepository, UUID> {
}
