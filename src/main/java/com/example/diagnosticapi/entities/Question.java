package com.example.diagnosticapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qt;
    @Enumerated(EnumType.STRING)
    private Choix choix;
    @ManyToOne()
    @JoinColumn(name="fk_category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQt() {
        return qt;
    }

    public Choix getChoix() {
        return choix;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }
}
