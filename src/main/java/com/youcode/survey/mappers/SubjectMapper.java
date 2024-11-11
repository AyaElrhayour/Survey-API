package com.youcode.survey.mappers;

import com.youcode.survey.models.dto.Subject.SubjectCreatingDTO;
import com.youcode.survey.models.dto.Subject.SubjectOnlyDTO;
import com.youcode.survey.models.dto.Subject.SubjectResponseDTO;
import com.youcode.survey.models.entities.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toEntitySubject(SubjectCreatingDTO subjectCreatingDTO);
    SubjectCreatingDTO toSubjectCreatingDTO(Subject subject);

//    @Mapping(source = "parent" , target = "parent")
//    @Mapping(source = "surveyEdition", target = "surveyEdition")

    SubjectOnlyDTO toSubjectOnlyDTO(Subject subject);

    SubjectResponseDTO toSubjectResponseDTO(Subject subject);

}
