package com.youcode.survey.services.implementations;

import com.youcode.survey.mappers.AnswerMapper;
import com.youcode.survey.models.dto.Answer.AnswerCreatingDTO;
import com.youcode.survey.models.dto.Answer.AnswerOnlyDTO;
import com.youcode.survey.models.entities.Answer;
import com.youcode.survey.models.entities.Question;
import com.youcode.survey.models.enums.Type;
import com.youcode.survey.repositories.AnswerRepository;
import com.youcode.survey.repositories.QuestionRepository;
import com.youcode.survey.services.interfaces.AnswerSIN;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AnswerSIM implements AnswerSIN {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;

    @Override
    public AnswerCreatingDTO createAnswer(AnswerCreatingDTO answerDTO) {
        UUID questionId = answerDTO.getQuestionId();
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("The question with ID " + questionId + " does not exist"));
        List<Answer> existingAnswers = answerRepository.findByQuestionId(questionId);
        if (question.getType() == Type.SINGLE_CHOICE) {
            if (!existingAnswers.isEmpty()) {
                throw new IllegalArgumentException("Cannot add more answers to a SINGLE_CHOICE question.");
            }
        } else if (question.getType() == Type.MULTIPLE_CHOICE) {
            if (existingAnswers.size() >= question.getAnswersCount()) {
                throw new IllegalArgumentException("The question already has the maximum number of answers allowed.");
            }
        }
        return answerMapper.toAnswerCreatingDTO(answerRepository.save(answerMapper.toAnswer(answerDTO)));
    }


    @Override
    public List<AnswerOnlyDTO> getAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream()
                .map(answerMapper::toAnswerOnlyDTO)
                .toList();
    }

    @Override
    public AnswerOnlyDTO getAnswerByID(UUID id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The answer with ID " + id + " does not exist"));

        return answerMapper.toAnswerOnlyDTO(answer);
    }

    @Override
    public boolean deleteAnswer(UUID id) {
        if (answerRepository.existsById(id)) {
            answerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public AnswerCreatingDTO updateAnswer(UUID id, AnswerCreatingDTO answerDTO) {
        Answer existingAnswer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The answer with ID " + id + " does not exist"));

        UUID questionId = answerDTO.getQuestionId();
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("The question with ID " + questionId + " does not exist"));
        List<Answer> existingAnswers = answerRepository.findByQuestionId(questionId);
        if (question.getType() == Type.SINGLE_CHOICE && !existingAnswers.isEmpty() && !existingAnswer.getId().equals(id)) {
            throw new IllegalArgumentException("Cannot update to this answer for a SINGLE_CHOICE question with existing answers.");
        } else if (question.getType() == Type.MULTIPLE_CHOICE && existingAnswers.size() > question.getAnswersCount()) {
            throw new IllegalArgumentException("Cannot exceed the maximum number of answers allowed for this question.");
        }
        existingAnswer.setText(answerDTO.getText());
        existingAnswer.setQuestion(question);

        return answerMapper.toAnswerCreatingDTO(answerRepository.save(existingAnswer));
    }

}
