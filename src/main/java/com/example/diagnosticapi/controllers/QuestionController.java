package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.Question;
import com.example.diagnosticapi.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.insertQuestion(question);
    }

    @PostMapping("/add-multiple")
    public List<Question> addQuestions(@RequestBody List<Question> questions) {
        return questionService.insertQuestion(questions);
    }
}
