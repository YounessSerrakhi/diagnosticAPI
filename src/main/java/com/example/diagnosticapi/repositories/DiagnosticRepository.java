package com.example.diagnosticapi.repositories;
import com.example.diagnosticapi.entities.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticRepository extends JpaRepository<Diagnostic,Long> {
}