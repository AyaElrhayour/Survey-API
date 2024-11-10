package com.youcode.survey.mappers;

import com.youcode.survey.models.dto.Subject.SubjectCreatingDTO;
import com.youcode.survey.models.dto.Subject.SubjectParentResponseDTO;
import com.youcode.survey.models.dto.Subject.SubjectReadingDTO;
import com.youcode.survey.models.dto.Subject.SubjectResponseDTO;
import com.youcode.survey.models.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toEntitySubject(SubjectCreatingDTO subjectCreatingDTO);

//    @Mapping(source = "parent" , target = "parent")
//    @Mapping(source = "surveyEdition", target = "surveyEdition")
    SubjectParentResponseDTO toSubjectParentResponseDTO(Subject subject);

    SubjectReadingDTO  toSubjectReadingDTO(Subject subject);

    SubjectResponseDTO toSubjectResponseDTO(Subject subject);

}
