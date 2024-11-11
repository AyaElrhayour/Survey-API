package com.youcode.survey.services.implementations;

import com.youcode.survey.mappers.SurveyMapper;
import com.youcode.survey.models.dto.Survey.SurveyCreatingDTO;
import com.youcode.survey.models.dto.Survey.SurveyReadingDTO;
import com.youcode.survey.models.entities.Owner;
import com.youcode.survey.models.entities.Survey;
import com.youcode.survey.repositories.OwnerRepository;
import com.youcode.survey.repositories.SurveyRepository;
import com.youcode.survey.services.interfaces.SurveySIN;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SurveySIM implements SurveySIN {

    private SurveyRepository surveyRepository;
    private OwnerRepository ownerRepository;
    private SurveyMapper surveyMapper;

    @Override
    public SurveyCreatingDTO createSurvey(SurveyCreatingDTO surveyCreatingDTO) {
        Survey survey = surveyMapper.toSurvey(surveyCreatingDTO);
        if (surveyCreatingDTO.getOwnerId() != null) {
            Owner owner = ownerRepository.findById(surveyCreatingDTO.getOwnerId()).orElseThrow(()-> new RuntimeException("Owner not found"));
            survey.setOwner(owner);
        }
        return surveyMapper.toSurveyCreatingDTO(surveyRepository.save(survey));
    }

    @Override
    public List<SurveyReadingDTO> getAllSurveys() {
       List<Survey> surveys = surveyRepository.findAll();
       if (surveys.isEmpty()) {
           throw new RuntimeException("No surveys found");
       }
       return surveys.stream().map(surveyMapper::toSurveyReadingDTO).toList();
    }

    @Override
    public SurveyReadingDTO getSurveyById(UUID id) {
            Survey survey = surveyRepository.findById(id).orElseThrow(()-> new RuntimeException("Survey not found"));
            return surveyMapper.toSurveyReadingDTO(survey);
    }

    @Override
    public SurveyReadingDTO getSurveyByTitle(String title) {
            Survey survey = surveyRepository.findByTitle(title).orElseThrow(()-> new RuntimeException("Survey not found"));
            return surveyMapper.toSurveyReadingDTO(survey);
    }

    @Override
    public boolean deleteSurvey(UUID id) {
       if (surveyRepository.existsById(id)) {
           surveyRepository.deleteById(id);
           return true;
       }
       return false;
    }

    @Override
    public SurveyCreatingDTO updateSurvey(UUID id, SurveyCreatingDTO  surveyCreatingDTO) {

       Survey survey = surveyRepository.findById(id).orElseThrow(() -> new RuntimeException("Survey not found"));
        survey.setTitle(surveyCreatingDTO.getTitle());
        survey.setDescription(surveyCreatingDTO.getDescription());
        survey.setOwner(ownerRepository.findById(surveyCreatingDTO.getOwnerId()).orElseThrow(()-> new RuntimeException("Owner not found")));
        return surveyMapper.toSurveyCreatingDTO(surveyRepository.save(survey));
    }
}
