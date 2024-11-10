package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Owner.OwnerDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;

import java.util.List;
import java.util.UUID;

public interface OwnerSIN {

    OwnerDTO createOwner(OwnerDTO ownerDTO);
    List<OwnerReadingEmbdDTO> getAllOwners();
    OwnerReadingEmbdDTO getOwnerById(UUID id);
    OwnerReadingEmbdDTO getOwnerByName(String name);
    Boolean deleteOwnerById(UUID id);
    OwnerDTO updateOwnerById(UUID id, OwnerDTO ownerDTO);

    
}
