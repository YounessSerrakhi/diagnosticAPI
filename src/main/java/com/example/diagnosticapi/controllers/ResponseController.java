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

import java.util.List;

@RestController
public class ResponseController {
    @Autowired
    ResponseService responseService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionChoixService questionChoixService;

    @PostMapping("/storeReponse")
    public ResponseEntity<String> store(@RequestParam Long userId,@RequestParam List<Long> questions,@RequestParam List<Long> choix){
        User user = userService.getUserById(userId);
        boolean allResponsesSaved = true;
        List<QuestionChoix> questionChoixs= questionChoixService.getQuestionChoix(questions,choix);
        for(QuestionChoix questionChoix : questionChoixs){
            Response result = responseService.saveResponse(user, questionChoix);
            if (result == null) {
                allResponsesSaved = false;
                break;
            }

        }

        if (allResponsesSaved) {
        return ResponseEntity.ok("User choices stored successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to store user choice.");
    }

   }

}
