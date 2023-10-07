package com.example.diagnosticapi.repositories;

import com.example.diagnosticapi.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response,Long> {
}
