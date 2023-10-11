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
        try {
            return questionRepository.save(question);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert the question: " + e.getMessage());
        }
    }
    public boolean insertQuestion(List<Question> questions) {
        try {
            questionRepository.saveAll(questions);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
