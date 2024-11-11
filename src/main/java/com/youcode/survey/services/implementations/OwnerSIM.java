package com.youcode.survey.services.implementations;


import com.youcode.survey.models.dto.Owner.OwnerDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingDTO;
import com.youcode.survey.models.entities.Owner;
import com.youcode.survey.mappers.OwnerMapper;
import com.youcode.survey.repositories.OwnerRepository;
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
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner toOwnerEntity = ownerMapper.toEntity(ownerDTO);
        Owner owner = ownerRepository.save(toOwnerEntity);
        return ownerMapper.toOwnerCreatingDTO(owner);
    }

    @Override
    public List<OwnerReadingDTO> getAllOwners() {
        List<Owner> ownerList = ownerRepository.findAll();
        return ownerList.stream().map(ownerMapper::ReturnResponseWhenReading).toList();
    }

    @Override
    public OwnerReadingDTO getOwnerById(UUID id) {
        if (ownerRepository.existsById(id)) {
            Owner owner = ownerRepository.findById(id).get();
            return ownerMapper.ReturnResponseWhenReading(owner);
        }else {
            throw new EntityNotFoundException("The owner with id " + id + " does not exist");
        }
    }

    @Override
    public OwnerReadingDTO getOwnerByName(String name) {
        Optional<Owner> owner = ownerRepository.findByName(name);
        if (owner.isPresent()) {
            return ownerMapper.ReturnResponseWhenReading(owner.get());
        }else {
            throw new EntityNotFoundException("The owner with name " + name + " does not exist");
        }
    }

    @Override
    public Boolean deleteOwnerById(UUID id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return true ;
        }else {
            throw new EntityNotFoundException("The owner with id " + id + " does not exist");
        }
    }

    @Override
    public OwnerDTO updateOwnerById(UUID id, OwnerDTO ownerDTO) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            owner.get().setName(ownerDTO.getName());
            return ownerMapper.toOwnerCreatingDTO(ownerRepository.save(owner.get()));
        }else {
            throw new EntityNotFoundException("The owner with id " + id + " does not exist");
        }

    }
}
