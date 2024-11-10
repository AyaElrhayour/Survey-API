package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Survey.SurveyCreatingDTO;
import com.youcode.survey.models.dto.Survey.SurveyReadingDTO;

import java.util.List;
import java.util.UUID;

public interface SurveySIN {

    SurveyCreatingDTO createSurvey(SurveyCreatingDTO SurveyCreatingDTO);
    List<SurveyReadingDTO> getAllSurveys();
    SurveyReadingDTO getSurveyById(UUID id);
    SurveyReadingDTO getSurveyByTitle(String title);
    boolean deleteSurvey(UUID id);
    SurveyCreatingDTO updateSurvey(UUID id, SurveyCreatingDTO surveyCreatingDTO);
}
