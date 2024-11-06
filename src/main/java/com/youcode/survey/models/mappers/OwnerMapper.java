package com.youcode.survey.models.mappers;


import com.youcode.survey.models.dto.Owner.OwnerCreatingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
import com.youcode.survey.models.entities.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {


    Owner  toEntity(OwnerCreatingDTO ownerCreatingDTO);

    OwnerCreatingDTO toOwnerCreatingDTO(Owner owner);

    OwnerReadingDTO ReturnResponseWhenCreated(Owner owner);

    OwnerReadingEmbdDTO ReturnResponseWhenReading(Owner owner);
}
