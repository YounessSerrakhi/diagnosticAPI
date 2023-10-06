package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkUserAttributes(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);

        return userOptional.isPresent(); // Returns true if a user is found, false otherwise
    }
}
