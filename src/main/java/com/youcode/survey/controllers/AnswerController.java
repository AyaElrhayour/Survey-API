package com.youcode.survey.controllers;

import com.youcode.survey.models.dto.Answer.AnswerCreatingDTO;
import com.youcode.survey.models.dto.Answer.AnswerOnlyDTO;
import com.youcode.survey.services.interfaces.AnswerSIN;
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
@RequestMapping(path = "api/answers", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@AllArgsConstructor
public class AnswerController {

    private AnswerSIN answerSIN;

    @PostMapping
    public ResponseEntity<AnswerCreatingDTO> createAnswer(@Valid @RequestBody AnswerCreatingDTO answerCreatingDTO) {
        AnswerCreatingDTO createdAnswer = answerSIN.createAnswer(answerCreatingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping
    public ResponseEntity<List<AnswerOnlyDTO>> getAnswers() {
        List<AnswerOnlyDTO> answers = answerSIN.getAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerOnlyDTO> getAnswerById(@PathVariable UUID id) {
        AnswerOnlyDTO answer = answerSIN.getAnswerByID(id);
        return ResponseEntity.ok(answer);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnswerCreatingDTO> updateAnswer(
            @PathVariable UUID id,
            @Valid @RequestBody AnswerCreatingDTO answerCreatingDTO) {
        AnswerCreatingDTO updatedAnswer = answerSIN.updateAnswer(id, answerCreatingDTO);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable UUID id) {
        if (answerSIN.deleteAnswer(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
