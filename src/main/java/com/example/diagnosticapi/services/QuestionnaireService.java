package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.Questionnaire;
import com.example.diagnosticapi.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getQuestionnaire() {
        List<Questionnaire> diag = questionnaireRepository.findQuestionnaire();
        return diag;
    }

}