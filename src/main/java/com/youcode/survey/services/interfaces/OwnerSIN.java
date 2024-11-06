package com.youcode.survey.services.interfaces;

import com.youcode.survey.models.dto.Owner.OwnerCreatingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;

import java.util.List;
import java.util.UUID;

public interface OwnerSIN {

    OwnerCreatingDTO createOwner(OwnerCreatingDTO ownerCreatingDTO);
    List<OwnerReadingEmbdDTO> getAllOwners();
    OwnerReadingEmbdDTO getOwnerById(UUID id);
    OwnerReadingEmbdDTO getOwnerByName(String name);
    Boolean deleteOwnerById(UUID id);
    OwnerCreatingDTO updateOwnerById(UUID id,OwnerCreatingDTO ownerCreatingDTO);

    
}
