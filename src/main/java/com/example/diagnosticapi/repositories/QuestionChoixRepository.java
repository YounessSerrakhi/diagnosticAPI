package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.QuestionChoix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionChoixRepository extends JpaRepository<QuestionChoix,Long> {
}
