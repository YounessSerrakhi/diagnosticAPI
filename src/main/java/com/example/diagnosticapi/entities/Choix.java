package com.example.diagnosticapi.entities;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String choix;
    private Integer note;
    @OneToMany(mappedBy = "choix")
    private Set<QuestionChoix> questionChoixSet = new HashSet<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    /*public Set<QuestionChoix> getQuestionChoixSet() {
        return questionChoixSet;
    }*/

    public void setQuestionChoixSet(Set<QuestionChoix> questionChoixSet) {
        this.questionChoixSet = questionChoixSet;
    }
}
