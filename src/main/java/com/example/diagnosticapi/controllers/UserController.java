package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public boolean checkUserAttributes(@RequestParam String username, @RequestParam String password) {
        return userService.checkUserAttributes(username, password);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }
}
