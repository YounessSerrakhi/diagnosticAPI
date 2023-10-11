package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.Questionnaire;
import com.example.diagnosticapi.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionnaireController {
    @Autowired  //injection de dependence pour injecter le service dans le controller
    private QuestionnaireService questionnaireService;
    @RequestMapping(method = RequestMethod.GET ,value = "/questionnaire")
    public List<Questionnaire> getDiagnostic(){
        return questionnaireService.getQuestionnaire();
    }
}