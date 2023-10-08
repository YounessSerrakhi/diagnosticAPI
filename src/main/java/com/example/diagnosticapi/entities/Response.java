package com.example.diagnosticapi.entities;

import jakarta.persistence.*;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "question_choix_id")
    private QuestionChoix questionChoix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionChoix getQuestionChoix() {
        return questionChoix;
    }

    public void setQuestionChoix(QuestionChoix questionChoix) {
        this.questionChoix = questionChoix;
    }
}
