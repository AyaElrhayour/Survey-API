package com.youcode.survey.mappers;

import com.youcode.survey.models.dto.Survey.SurveyCreatingDTO;
import com.youcode.survey.models.dto.Survey.SurveyReadingDTO;
import com.youcode.survey.models.entities.Survey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    Survey toSurvey(SurveyCreatingDTO surveyCreatingDTO);
    SurveyCreatingDTO toSurveyCreatingDTO(Survey survey);
    SurveyReadingDTO toSurveyReadingDTO(Survey survey);

}
