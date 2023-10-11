package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.repositories.QuestionChoixRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionChoixService {
    @Autowired
    QuestionChoixRepository questionChoixRepository;

    public List<QuestionChoix> getQuestionChoix(List<Long> questionIds, List<Long> choixIds) {
        List<QuestionChoix> questionChoixList = new ArrayList<>();

        for (int i = 0; i < questionIds.size(); i++) {
            Long questionId = questionIds.get(i);
            Long choixId = choixIds.get(i);
            QuestionChoix questionChoix = questionChoixRepository.findByQuestionIdAndChoixId(questionId, choixId);

            if (questionChoix != null) {
                questionChoixList.add(questionChoix);
            }
        }

        return questionChoixList;
    }

    public QuestionChoix getQuestionChoixById(Long questionChoixId) {
        return questionChoixRepository.findById(questionChoixId).
        orElseThrow(() -> new EntityNotFoundException("QuestionChoix not found with ID: " + questionChoixId));
    }
}
