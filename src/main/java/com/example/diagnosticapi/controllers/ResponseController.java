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

@RestController
public class ResponseController {
    @Autowired
    ResponseService responseService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionChoixService questionChoixService;

    @PostMapping("/storeReponse")
    public ResponseEntity<String> store(@RequestParam Long userId,@RequestParam Long questionChoixId){
        User user = userService.getUserById(userId);
        QuestionChoix questionChoix = questionChoixService.getQuestionChoixById(questionChoixId);


    Response result = responseService.saveResponse(user, questionChoix);

        if (result != null) {
        return ResponseEntity.ok("User choice stored successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to store user choice.");
    }

   }

}
