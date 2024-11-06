package com.youcode.survey.controllers;


import com.youcode.survey.models.dto.Owner.OwnerCreatingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
import com.youcode.survey.repositories.OwnerRepository;
import com.youcode.survey.services.interfaces.OwnerSIN;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/owners")
@Validated
public class OwnerController {


    @Autowired
    private OwnerSIN ownerSIN;

    @PostMapping
    public OwnerCreatingDTO createOwner(@Valid @RequestBody OwnerCreatingDTO ownerCreatingDTO ) {
        return ownerSIN.createOwner(ownerCreatingDTO);
    }

    @GetMapping
    public List<OwnerReadingEmbdDTO> getAllOwners(){
        return ownerSIN.getAllOwners();
    }

//    @GetMapping("/{id}")
//    public OwnerReadingEmbdDTO getOwnerById(
//            @PathVariable("id")){
//        return ownerSIN.getOwnerById(id);
//    }


}
