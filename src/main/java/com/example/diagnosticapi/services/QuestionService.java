package com.example.diagnosticapi.services;
import com.example.diagnosticapi.entities.Category;
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
        return questionRepository.findAll();
    }
    public List<Question> getQuestionByCategorie(Category category){
        return questionRepository.findByCategory(category);
    }
    public Question insertQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> insertQuestion(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

}
