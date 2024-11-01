package com.youcode.survey.repositories;

import com.youcode.survey.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    Optional<Subject> findByTitle(String title);
    List<Subject> findAllByParentIdIsNull();
    List<Subject> findAllByParentId(UUID id);

}
