package com.example.diagnosticapi.services;

import com.example.diagnosticapi.entities.*;
import com.example.diagnosticapi.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkUserAttributes(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(username, password);

        return userOptional.isPresent(); // Returns true if a user is found, false otherwise
    }
      public User getUserById(Long userId) {
          return userRepository.findById(userId)
                  .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
      }


    /*public Hashtable<String, Integer> calculateCategorieResult(Long userId) {
        Hashtable<String, Integer> categoryResult = new Hashtable<>();
        User user = getUserById(userId);
        List<Response> userResponses = user.getResponses();
        List<QuestionChoix> questionChoixSet = new ArrayList<>();
        for (Response response : userResponses){
            questionChoixSet.add(response.getQ);
            System.out.println("---------------------------------------"+response);
        }

        return userResponses;
    }*/

    public Map<String, Integer> calculateCategorieResult(Long userId) {
        Map<String, Integer> categorieResult = new HashMap<>();
        User user = getUserById(userId);
        List<Response> userResponses = user.getResponses();

        for (Response response : userResponses) {
            Question question = response.getQuestionChoix().getQuestion();
            Category category = question.getCategory();
            int note = response.getQuestionChoix().getChoix().getNote();

            // Check if the category is already in the map
            if (categorieResult.containsKey(category.getName())) {
                // If it is, add the note to the existing total
                int currentTotal = categorieResult.get(category.getName());
                categorieResult.put(category.getName(), currentTotal + note);
            } else {
                // If it's not, create a new entry in the map
                categorieResult.put(category.getName(), note);
            }
        }
        for (Integer value : categorieResult.values()) {
            int result = (value * 100) / 25;
            System.out.println("Value: " + value);
        }
        categorieResult.replaceAll((key, value) -> (value * 100) / 25);
        return categorieResult;
    }

    public int calculateGlobalResult(Long userId) {
        int globalResult = 0;
        User user = getUserById(userId);
        List<Response> userResponses = user.getResponses();

        for (Response response : userResponses){
            globalResult+=response.getQuestionChoix().getNote();
        }

        return globalResult*100/25;
    }

}
