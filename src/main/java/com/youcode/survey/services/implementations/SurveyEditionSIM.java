package com.youcode.survey.services.implementations;

import com.youcode.survey.mappers.SurveyEditionMapper;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionCreatingDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionReadingDTO;
import com.youcode.survey.models.entities.Survey;
import com.youcode.survey.models.entities.SurveyEdition;
import com.youcode.survey.repositories.SubjectRepository;
import com.youcode.survey.repositories.SurveyEditionRepository;
import com.youcode.survey.repositories.SurveyRepository;
import com.youcode.survey.services.interfaces.SurveyEditionSIN;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SurveyEditionSIM implements SurveyEditionSIN {

    private final SubjectRepository subjectRepository;
    private SurveyEditionRepository surveyEditionRepository;
    private SurveyEditionMapper surveyEditionMapper;
    private SurveyRepository surveyRepository;


    @Override
    public SurveyEditionCreatingDTO createSurveyEdition(SurveyEditionCreatingDTO surveyEditionCreatingDTO) {
        SurveyEdition surveyEdition = surveyEditionMapper.toSurveyEdition(surveyEditionCreatingDTO);
        if (surveyEditionCreatingDTO.getSurveyId() != null) {
            Survey survey = surveyRepository.findById(surveyEditionCreatingDTO.getSurveyId()).orElseThrow(()-> new RuntimeException("Survey not found"));
            surveyEdition.setSurvey(survey);
        }
        return surveyEditionMapper.toSurveyEditionCreatingDTO(surveyEditionRepository.save(surveyEdition));
    }

    @Override
    public List<SurveyEditionReadingDTO> getAllSurveyEditions() {
        List<SurveyEdition> surveyEditionList = surveyEditionRepository.findAll();
        if (surveyEditionList.isEmpty()) {
            throw new RuntimeException("No survey found");
        }
        return surveyEditionList.stream().map(surveyEditionMapper::toSurveyEditionReadingDTO).toList();
    }

    @Override
    public SurveyEditionReadingDTO getSurveyEditionById(UUID id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElseThrow(()-> new RuntimeException("Survey not found"));
        return surveyEditionMapper.toSurveyEditionReadingDTO(surveyEdition);
    }

    @Override
    public boolean deleteSurveyEditionById(UUID id) {
        if (surveyEditionRepository.existsById(id)) {
            surveyEditionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SurveyEditionCreatingDTO updateSurveyEdition(UUID id, SurveyEditionCreatingDTO surveyEditionCreatingDTO) {
       SurveyEdition surveyEdition = surveyEditionRepository.findById(id).orElseThrow(()-> new RuntimeException("Survey not found"));
       surveyEdition.setCreationDate(surveyEditionCreatingDTO.getCreationDate());
       surveyEdition.setStartDate(surveyEditionCreatingDTO.getStartDate());
       surveyEdition.setYear(surveyEditionCreatingDTO.getYear());
       surveyEdition.setSurvey(surveyRepository.findById(surveyEditionCreatingDTO.getSurveyId()).orElseThrow(() -> new RuntimeException("survey not found")));
       return surveyEditionMapper.toSurveyEditionCreatingDTO(surveyEditionRepository.save(surveyEdition));
    }
}
