package com.youcode.survey.controllers;


import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionCreatingDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionOnlyDTO;
import com.youcode.survey.models.dto.SurveyEdition.SurveyEditionReadingDTO;
import com.youcode.survey.models.entities.SurveyEdition;
import com.youcode.survey.repositories.SurveyEditionRepository;
import com.youcode.survey.services.interfaces.SurveyEditionSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/surveyEditions" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SurveyEditionController {

    private SurveyEditionSIN surveyEditionSIN;
    private SurveyEditionRepository surveyEditionRepository;

    @PostMapping
    public SurveyEditionCreatingDTO create(@RequestBody @Valid SurveyEditionCreatingDTO surveyEditionDTO) {
        return surveyEditionSIN.createSurveyEdition(surveyEditionDTO);
    }

    @GetMapping
    public List<SurveyEditionOnlyDTO> getAll() {
        return surveyEditionSIN.getAllSurveyEditions();
    }

    @GetMapping("/{id}")
    public SurveyEditionReadingDTO getSurveyEdition(@PathVariable UUID id) {
        return surveyEditionSIN.getSurveyEditionById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyEditionCreatingDTO> updateSurveyEdition(@RequestBody SurveyEditionCreatingDTO surveyEditionCreatingDTO, @PathVariable UUID id) {
        return ResponseEntity.ok(surveyEditionSIN.updateSurveyEdition(id,surveyEditionCreatingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurveyEdition(@PathVariable UUID id) {
        if (surveyEditionSIN.deleteSurveyEditionById(id)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey Edition Not Found");
        }
    }
}
