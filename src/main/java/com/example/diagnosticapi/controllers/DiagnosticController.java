package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.Diagnostic;
import com.example.diagnosticapi.services.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiagnosticController {
    @Autowired  //injection de dependence pour injecter le service dans le controller
    private DiagnosticService diagnosticService;
    @RequestMapping(method = RequestMethod.GET ,value = "/diagnostic")
    public List<Diagnostic> getDiagnostic(){
        return diagnosticService.getDiagnostic();
    }
}