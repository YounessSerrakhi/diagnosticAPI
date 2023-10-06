package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
