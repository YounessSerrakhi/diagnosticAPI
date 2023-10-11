package com.example.diagnosticapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne()
    @JoinColumn(name="fk_questionnaire_id")
    private Questionnaire questionnaire;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_category_id",referencedColumnName = "id")
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
