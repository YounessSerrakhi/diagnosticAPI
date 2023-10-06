package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.Question;
import com.example.diagnosticapi.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getQuestion(){
        List<Question> questions = questionRepository.findAll();
        return questions;

    }
}
