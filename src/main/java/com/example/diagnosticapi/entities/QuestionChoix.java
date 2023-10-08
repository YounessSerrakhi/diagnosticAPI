package com.example.diagnosticapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questionChoix")
//@JsonIgnoreProperties("choix")



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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Response> responses;
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Choix getChoix() {
        return choix;
    }
    public int getNote() {
        return choix.getNote();
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
