package com.example.diagnosticapi.services;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.diagnosticapi.entities.Question;
import com.example.diagnosticapi.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public List<Question> getQuestion(){
        List<Question> questions = questionRepository.findAll();
        return questions;
    }
    public Question insertQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> insertQuestion(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }
}
