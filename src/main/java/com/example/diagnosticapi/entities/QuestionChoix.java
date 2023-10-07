package com.example.diagnosticapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "questionChoix")
public class QuestionChoix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name="choix_id")
    private Choix choix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
