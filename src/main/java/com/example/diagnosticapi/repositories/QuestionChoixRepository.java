package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.QuestionChoix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionChoixRepository extends JpaRepository<QuestionChoix,Long> {

    QuestionChoix findByQuestionIdAndChoixId(Long questionId, Long choixId);
}
