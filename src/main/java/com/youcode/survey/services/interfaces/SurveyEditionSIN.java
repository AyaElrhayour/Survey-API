package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionCreatingDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionReadingDTO;

import java.util.List;
import java.util.UUID;

public interface SurveyEditionSIN {

    SurveyEditionCreatingDTO createSurveyEdition(SurveyEditionCreatingDTO surveyEditionCreatingDTO);
    List<SurveyEditionReadingDTO> getAllSurveyEditions();
    SurveyEditionReadingDTO getSurveyEditionById(UUID id);
    boolean deleteSurveyEditionById(UUID id);
    SurveyEditionCreatingDTO updateSurveyEdition(UUID id, SurveyEditionCreatingDTO SurveyEditionCreatingDTO);

}
