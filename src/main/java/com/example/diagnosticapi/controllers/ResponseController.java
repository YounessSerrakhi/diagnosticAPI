package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.Response;
import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.services.QuestionChoixService;
import com.example.diagnosticapi.services.ResponseService;
import com.example.diagnosticapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResponseController {
    @Autowired
    ResponseService responseService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionChoixService questionChoixService;

    @PostMapping("/storeReponse")
    public Map<String, String> store(@RequestParam Long userId, @RequestParam List<Long> questions, @RequestParam List<Long> choix) {
        Map<String, String> response = new HashMap<>();

        try {
            User user = userService.getUserById(userId);
            List<QuestionChoix> questionChoixs = questionChoixService.getQuestionChoix(questions, choix);

            boolean allResponsesSaved = true;

            for (QuestionChoix questionChoix : questionChoixs) {
                Response result = responseService.saveResponse(user, questionChoix);
                if (result == null) {
                    allResponsesSaved = false;
                    break;
                }
            }

            if (allResponsesSaved) {
                response.put("message", "stored correctly");
            } else {
                response.put("message", "failed");
            }
        } catch (Exception e) {
            response.put("message", "An error occurred: " + e.getMessage());
        }

        return response;
    }

}
