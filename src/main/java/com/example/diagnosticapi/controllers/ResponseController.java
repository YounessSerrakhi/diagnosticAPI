package com.example.diagnosticapi.controllers;

import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.services.ResponseService;
import com.example.diagnosticapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @Autowired
    ResponseService responseService;

   // @PostMapping("/storeReponse")
   // public ResponseEntity<String> store(@RequestParam Long userId,@RequestParam Long questionChoixId){
       // User user = UserService.getUserById(userId);

   // }

}
