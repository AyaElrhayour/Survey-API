package com.youcode.survey.controllers;


import com.youcode.survey.models.dto.Owner.OwnerCreatingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
import com.youcode.survey.repositories.OwnerRepository;
import com.youcode.survey.services.interfaces.OwnerSIN;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "api/owners", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OwnerController {


    @Autowired
    private OwnerSIN ownerSIN;

    @PostMapping
    public OwnerCreatingDTO createOwner( @RequestBody OwnerCreatingDTO ownerCreatingDTO) {
        System.out.println(ownerCreatingDTO);
        return ownerSIN.createOwner(ownerCreatingDTO);
    }

    @GetMapping
    public List<OwnerReadingEmbdDTO> getAllOwners(){
        return ownerSIN.getAllOwners();
    }

    @GetMapping("/{ownerId}")
    public OwnerReadingEmbdDTO getOwnerById(@PathVariable UUID id){
        return ownerSIN.getOwnerById(id);
    }

    @GetMapping("/byname/{ownerName}")
    public OwnerReadingEmbdDTO getOwnerByName(@PathVariable String name){
        return ownerSIN.getOwnerByName(name);
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable UUID id){
        if (ownerSIN.deleteOwnerById(id)) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner could not be deleted");
        }
    }

    @PutMapping("/{ownerId}")
    public OwnerCreatingDTO updateOwnerById(@PathVariable UUID id, @RequestBody OwnerCreatingDTO ownerCreatingDTO){
        return ownerSIN.updateOwnerById(id, ownerCreatingDTO);
    }
}
