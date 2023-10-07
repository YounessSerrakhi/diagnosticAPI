package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.repositories.QuestionChoixRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionChoixService {
    @Autowired
    QuestionChoixRepository questionChoixRepository;

    public QuestionChoix getQuestionChoixById(Long questionChoixId) {
        return questionChoixRepository.findById(questionChoixId).
        orElseThrow(() -> new EntityNotFoundException("QuestionChoix not found with ID: " + questionChoixId));
    }
}
