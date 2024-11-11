package com.youcode.survey.mappers;


import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionCreatingDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionOnlyDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionReadingDTO;
import com.youcode.survey.models.entities.Survey;
import com.youcode.survey.models.entities.SurveyEdition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyEditionMapper {

    SurveyEdition toSurveyEdition(SurveyEditionCreatingDTO surveyEditionCreatingDTO);
    SurveyEditionCreatingDTO toSurveyEditionCreatingDTO(SurveyEdition surveyEdition);
    SurveyEditionReadingDTO toSurveyEditionReadingDTO(SurveyEdition surveyEdition);
    SurveyEditionOnlyDTO toSurveyEditionOnlyDTO(SurveyEdition surveyEdition);
}
