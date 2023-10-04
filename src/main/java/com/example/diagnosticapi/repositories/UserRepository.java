package com.example.diagnosticapi.repositories;
import com.example.diagnosticapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
