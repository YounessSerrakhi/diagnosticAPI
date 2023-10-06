package com.example.diagnosticapi.controllers;

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
}
