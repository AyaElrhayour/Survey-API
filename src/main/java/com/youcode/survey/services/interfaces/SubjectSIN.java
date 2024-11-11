package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Subject.SubjectCreatingDTO;
import com.youcode.survey.models.dto.Subject.SubjectOnlyDTO;
import com.youcode.survey.models.dto.Subject.SubjectResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SubjectSIN {

    SubjectCreatingDTO createSubject(SubjectCreatingDTO subjectCreatingDTO);
    List<SubjectOnlyDTO> getSubjects();
    SubjectResponseDTO getSubjectById(UUID id);
    SubjectResponseDTO getSubjectByTitle(String title);
    Boolean deleteSubject(UUID id);
    SubjectCreatingDTO updateSubject(UUID id, SubjectCreatingDTO subjectCreatingDTO);
}
