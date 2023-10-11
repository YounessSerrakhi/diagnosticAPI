package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response,Long> {
}
