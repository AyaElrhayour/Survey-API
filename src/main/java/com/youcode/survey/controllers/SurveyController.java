package com.youcode.survey.controllers;


import com.youcode.survey.models.dto.Survey.SurveyCreatingDTO;
import com.youcode.survey.models.dto.Survey.SurveyReadingDTO;
import com.youcode.survey.models.entities.Survey;
import com.youcode.survey.repositories.SurveyRepository;
import com.youcode.survey.services.interfaces.SurveySIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/surveys", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SurveyController {

    private SurveySIN surveySIN;
    private SurveyRepository surveyRepository;

    @PostMapping
    public SurveyCreatingDTO createSurvey(@RequestBody @Valid SurveyCreatingDTO surveyDTO) {
        return surveySIN.createSurvey(surveyDTO);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @GetMapping("/{id}")
    public SurveyReadingDTO getSurveyById(@PathVariable UUID id) {
        return surveySIN.getSurveyById(id);
    }

    @GetMapping("/title/{title}")
    public SurveyReadingDTO getSurveyByTitle(@PathVariable String title) {
        return surveySIN.getSurveyByTitle(title);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyCreatingDTO> updateSurvey(@RequestBody @Valid SurveyCreatingDTO surveyDTO,@PathVariable UUID id) {
        return ResponseEntity.ok(surveySIN.updateSurvey(id, surveyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSurveyById(@PathVariable UUID id){
        if (surveySIN.deleteSurvey(id)) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey could not be deleted");
        }
    }

}
