package com.youcode.survey.controllers;


import com.youcode.survey.models.dto.Owner.OwnerDTO;
import com.youcode.survey.models.dto.Owner.OwnerReadingEmbdDTO;
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

@RestController
@RequestMapping(path = "api/owners", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OwnerController {


    @Autowired
    private OwnerSIN ownerSIN;

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
        System.out.println(ownerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerSIN.createOwner(ownerDTO));
    }

    @GetMapping
    public ResponseEntity<List<OwnerReadingEmbdDTO>> getAllOwners(){
        return ResponseEntity.ok(ownerSIN.getAllOwners());
    }

    @GetMapping("/{id}")
    public OwnerReadingEmbdDTO getOwnerById(@PathVariable UUID id){
        return ownerSIN.getOwnerById(id);
    }

    @GetMapping("/byname/{name}")
    public OwnerReadingEmbdDTO getOwnerByName(@PathVariable String name){
        return ownerSIN.getOwnerByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwnerById(@PathVariable UUID id){
        if (ownerSIN.deleteOwnerById(id)) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner could not be deleted");
        }
    }

    @PutMapping("/{id}")
    public OwnerDTO updateOwnerById(@PathVariable UUID id, @Valid @RequestBody OwnerDTO ownerDTO){
        return ownerSIN.updateOwnerById(id, ownerDTO);
    }
}
