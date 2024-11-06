package com.youcode.survey.services.implementations;


import com.youcode.survey.models.dto.Owner.OwnerCreatingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
import com.youcode.survey.models.entities.Owner;
import com.youcode.survey.models.mappers.OwnerMapper;
import com.youcode.survey.repositories.OwnerRepository;
import com.youcode.survey.repositories.SurveyRepository;
import com.youcode.survey.services.interfaces.OwnerSIN;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerSIM implements OwnerSIN {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public OwnerCreatingDTO createOwner(OwnerCreatingDTO ownerCreatingDTO) {
        Owner toOwnerEntity = ownerMapper.toEntity(ownerCreatingDTO);
        Owner owner = ownerRepository.save(toOwnerEntity);
        return ownerMapper.toOwnerCreatingDTO(owner);
    }

    @Override
    public List<OwnerReadingEmbdDTO> getAllOwners() {
        List<Owner> ownerList = ownerRepository.findAll();
        return ownerList.stream().map(ownerMapper::ReturnResponseWhenReading).toList();
    }

    @Override
    public OwnerReadingEmbdDTO getOwnerById(UUID id) {
        if (ownerRepository.existsById(id)) {
            Owner owner = ownerRepository.findById(id).get();
            return ownerMapper.ReturnResponseWhenReading(owner);
        }else {
            throw new EntityNotFoundException("The owner with id " + id + " does not exist");
        }
    }

    @Override
    public OwnerReadingEmbdDTO getOwnerByName(String name) {
        Optional<Owner> owner = ownerRepository.findByName(name);
        if (owner.isPresent()) {
            return ownerMapper.ReturnResponseWhenReading(owner.get());
        }else {
            throw new EntityNotFoundException("The owner with name " + name + " does not exist");
        }
    }

    @Override
    public Boolean deleteOwnerById(UUID id) {
       try{
           Optional<Owner> owner = ownerRepository.findById(id);
           if (owner.isPresent()) {
               ownerRepository.delete(owner.get());
               return true;
           }else {
               throw new EntityNotFoundException("The owner with id " + id + " does not exist");
           }
       }catch (EntityNotFoundException e) {
           e.printStackTrace();
       }
       return null ;
    }

    @Override
    public OwnerCreatingDTO updateOwnerById(UUID id,OwnerCreatingDTO ownerCreatingDTO) {
        if (ownerRepository.existsById(id)) {
            Owner owner = ownerMapper.toEntity(ownerCreatingDTO);
            Owner updatedOwner = ownerRepository.save(owner);
            return ownerMapper.toOwnerCreatingDTO(updatedOwner);
        }else {
            throw new EntityNotFoundException("The owner with id " + id + " does not exist");
        }
    }
}
