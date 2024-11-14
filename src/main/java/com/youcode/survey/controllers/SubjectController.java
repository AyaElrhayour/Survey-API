package com.youcode.survey.controllers;

import com.youcode.survey.models.dto.Subject.SubjectCreatingDTO;
import com.youcode.survey.models.dto.Subject.SubjectOnlyDTO;
import com.youcode.survey.models.dto.Subject.SubjectResponseDTO;
import com.youcode.survey.repositories.SubjectRepository;
import com.youcode.survey.services.interfaces.SubjectSIN;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SubjectController {

    private SubjectSIN subjectSIN;
    private SubjectRepository subjectRepository;

    @PostMapping
    public SubjectCreatingDTO createSubject(@RequestBody @Valid SubjectCreatingDTO subjectCreatingDTO) {
        return subjectSIN.createSubject(subjectCreatingDTO);
    }

    @GetMapping
    public List<SubjectOnlyDTO> getAllSubjects() {
        return subjectSIN.getSubjects();
    }

    @GetMapping("/{id}")
    public SubjectResponseDTO getSubjectById(@PathVariable UUID id) {
        return subjectSIN.getSubjectById(id);
    }

    @GetMapping("/title/{title}")
    public SubjectResponseDTO getSubjectByTitle(@PathVariable String title) {
        return subjectSIN.getSubjectByTitle(title);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectCreatingDTO> updateSubject(@RequestBody @Valid SubjectCreatingDTO subjectCreatingDTO, @PathVariable UUID id) {
        return ResponseEntity.ok(subjectSIN.updateSubject(id, subjectCreatingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable UUID id) {
        if (subjectSIN.deleteSubject(id)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject could not be deleted");
        }
    }
}
