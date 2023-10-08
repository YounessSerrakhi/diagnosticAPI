package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.Category;
import com.example.diagnosticapi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategory(Category category);

}
