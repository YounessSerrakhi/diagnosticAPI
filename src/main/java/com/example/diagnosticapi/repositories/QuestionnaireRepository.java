package com.example.diagnosticapi.repositories;
import com.example.diagnosticapi.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {

    @Query("SELECT DISTINCT d FROM Questionnaire d " +
            "LEFT JOIN FETCH d.cat ct ")
    List<Questionnaire> findQuestionnaire();
}

