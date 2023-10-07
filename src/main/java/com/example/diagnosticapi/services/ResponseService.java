package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.QuestionChoix;
import com.example.diagnosticapi.entities.Response;
import com.example.diagnosticapi.entities.User;
import com.example.diagnosticapi.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    ResponseRepository responseRepository;
    public Response saveResponse(User user, QuestionChoix questionChoix){
        Response res = new Response();
        res.setUser(user);
        res.setQuestionChoix(questionChoix);
        return responseRepository.save(res);

    }
}
