package com.youcode.survey.services.implementations;

import com.youcode.survey.mappers.SubjectMapper;
import com.youcode.survey.models.dto.Subject.SubjectCreatingDTO;
import com.youcode.survey.models.dto.Subject.SubjectOnlyDTO;
import com.youcode.survey.models.dto.Subject.SubjectResponseDTO;
import com.youcode.survey.models.entities.Subject;
import com.youcode.survey.models.entities.SurveyEdition;
import com.youcode.survey.repositories.SubjectRepository;
import com.youcode.survey.repositories.SurveyEditionRepository;
import com.youcode.survey.services.interfaces.SubjectSIN;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubjectSIM implements SubjectSIN {

    private SubjectRepository subjectRepository;
    private SurveyEditionRepository surveyEditionRepository;
    private SubjectMapper subjectMapper;


    @Override
    public SubjectCreatingDTO createSubject(SubjectCreatingDTO subjectCreatingDTO) {
        Subject subject = subjectMapper.toEntitySubject(subjectCreatingDTO);
        if (subjectCreatingDTO.getSurveyEditionId() != null) {
            SurveyEdition surveyEdition = surveyEditionRepository.findById(subjectCreatingDTO.getSurveyEditionId()).orElseThrow(() -> new RuntimeException("Survey edition not found"));
            subject.setSurveyEdition(surveyEdition);
        }
        return subjectMapper.toSubjectCreatingDTO(subjectRepository.save(subject));
    }

    @Override
    public List<SubjectOnlyDTO> getSubjects() {
      List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(subjectMapper::toSubjectOnlyDTO).toList();
    }

    @Override
    public SubjectResponseDTO getSubjectById(UUID id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        return subjectMapper.toSubjectResponseDTO(subject);
    }

    @Override
    public SubjectResponseDTO getSubjectByTitle(String title) {
        Subject subject = subjectRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("Subject not found"));
        return subjectMapper.toSubjectResponseDTO(subject);
    }

    @Override
    public Boolean deleteSubject(UUID id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SubjectCreatingDTO updateSubject(UUID id, SubjectCreatingDTO subjectCreatingDTO) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
        subject.setTitle(subjectCreatingDTO.getTitle());
        subject.setParent(subjectRepository.findById(subjectCreatingDTO.getParentId()).orElseThrow(() -> new RuntimeException("Parent not found")));
        return subjectMapper.toSubjectCreatingDTO(subjectRepository.save(subject));
    }
}
