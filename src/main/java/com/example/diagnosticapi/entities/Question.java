package com.example.diagnosticapi.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qt;
    @ManyToOne()
    @JoinColumn(name="fk_category_id")
    private Category category;
    @OneToMany(mappedBy = "question")
    private Set<QuestionChoix> questionChoix = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public Set<QuestionChoix> getQuestionChoix() {
        return questionChoix;
    }

    public void setQuestionChoix(Set<QuestionChoix> questionChoix) {
        this.questionChoix = questionChoix;
    }
}
