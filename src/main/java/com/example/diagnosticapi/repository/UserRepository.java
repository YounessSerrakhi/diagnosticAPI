package com.example.diagnosticapi.repository;
import com.example.diagnosticapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
