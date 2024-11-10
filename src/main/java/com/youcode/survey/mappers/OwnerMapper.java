package com.youcode.survey.mappers;


import com.youcode.survey.models.dto.Owner.OwnerDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
import com.youcode.survey.models.entities.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {


    Owner  toEntity(OwnerDTO ownerDTO);

    OwnerDTO toOwnerCreatingDTO(Owner owner);

    OwnerReadingEmbdDTO ReturnResponseWhenReading(Owner owner);
}
