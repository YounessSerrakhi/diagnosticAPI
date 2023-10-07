package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.Diagnostic;
import com.example.diagnosticapi.repositories.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticService {
    @Autowired
    DiagnosticRepository diagnosticRepository;

    public List<Diagnostic> getDiagnostic() {
        List<Diagnostic> diag = diagnosticRepository.findDiagnostic();
        return diag;
    }

}