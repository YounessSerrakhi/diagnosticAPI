package com.example.diagnosticapi.repositories;
import com.example.diagnosticapi.entities.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiagnosticRepository extends JpaRepository<Diagnostic,Long> {
    @Query("SELECT DISTINCT d FROM Diagnostic d " +
            "LEFT JOIN FETCH d.cat ct ")
    List<Diagnostic> findDiagnostic();
}
