package com.youcode.survey.controllers;

import com.youcode.survey.models.dto.Question.QuestionCreatingDTO;
import com.youcode.survey.models.dto.Question.QuestionReadingDTO;
import com.youcode.survey.services.interfaces.QuestionSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/questions", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@AllArgsConstructor
public class QuestionController {

    private final QuestionSIN questionSIN;

    @PostMapping
    public ResponseEntity<QuestionCreatingDTO> createQuestion(@Valid @RequestBody QuestionCreatingDTO questionCreatingDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionSIN.createQuestion(questionCreatingDTO));
    }

    @GetMapping
    public ResponseEntity<List<QuestionReadingDTO>> getAllQuestions(){
        return ResponseEntity.ok(questionSIN.readQuestions());
    }

    @GetMapping("/{id}")
    public QuestionReadingDTO getQuestionById(@PathVariable UUID id){
        return questionSIN.findQuestionById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable UUID id){
        if (questionSIN.deleteQuestion(id)) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question could not be deleted");
        }
    }

    @PutMapping("/{id}")
    public QuestionCreatingDTO updateQuestionById(@PathVariable UUID id, @Valid @RequestBody QuestionCreatingDTO questionCreatingDTO){
        return questionSIN.updateQuestion(id, questionCreatingDTO);
    }
}
