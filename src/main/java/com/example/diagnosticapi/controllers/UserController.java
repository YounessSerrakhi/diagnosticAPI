package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.Choix;
import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.Response;
import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public boolean checkUserAttributes(@RequestParam String username, @RequestParam String password) {
        return userService.checkUserAttributes(username, password);
    }

    @PostMapping("/user")
    public User getUser(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/globalResult")
    public int getGlobalResult(@RequestParam Long userId) {
        return userService.calculateGlobalResult(userId);
    }
    @GetMapping("/categoryResult")
    public Map<String, Integer> getCategoryResult() {
        return userService.calculateCategorieResult(1L);
    }
}
