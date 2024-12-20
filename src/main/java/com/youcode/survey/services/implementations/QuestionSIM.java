package com.youcode.survey.services.implementations;

import com.youcode.survey.mappers.QuestionMapper;
import com.youcode.survey.models.dto.Question.QuestionCreatingDTO;
import com.youcode.survey.models.dto.Question.QuestionReadingDTO;
import com.youcode.survey.models.entities.Question;
import com.youcode.survey.models.entities.Subject;
import com.youcode.survey.repositories.QuestionRepository;
import com.youcode.survey.repositories.SubjectRepository;
import com.youcode.survey.services.interfaces.QuestionSIN;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class QuestionSIM implements QuestionSIN {

    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;
    private SubjectRepository subjectRepository;

    @Override
    public QuestionCreatingDTO createQuestion(QuestionCreatingDTO questionCreatingDTO) {
        Question question = questionMapper.toQuestion(questionCreatingDTO);
        Subject subject = subjectRepository.findById(questionCreatingDTO.getSubjectId())
                .orElseThrow(EntityNotFoundException::new);
        question.setSubject(subject);
        return questionMapper.toQuestionCreatingDTO(questionRepository.save(question));
    }

    @Override
    public List<QuestionReadingDTO> readQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(question -> questionMapper.toQuestionReadingDTO(question))
                .toList();
    }

    @Override
    public QuestionReadingDTO findQuestionById(UUID id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The question with ID " + id + " does not exist"));

        return questionMapper.toQuestionReadingDTO(question);
    }

    @Override
    public boolean deleteQuestion(UUID id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public QuestionCreatingDTO updateQuestion(UUID id, QuestionCreatingDTO questionCreatingDTO) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The question with ID " + id + " does not exist"));

        existingQuestion.setText(questionCreatingDTO.getText());
        existingQuestion.setType(questionCreatingDTO.getType());
        existingQuestion.setAnswersCount(questionCreatingDTO.getAnswersCount());
        existingQuestion.setSubject(subjectRepository.findById(questionCreatingDTO.getSubjectId()).get());

        Question updatedQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toQuestionCreatingDTO(updatedQuestion);
    }
}
