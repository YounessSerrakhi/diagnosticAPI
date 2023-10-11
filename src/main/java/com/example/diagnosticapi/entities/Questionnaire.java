package com.example.diagnosticapi.entities;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.util.List;

@Entity
@Transactional
@Table(name = "questionnaire")
public class Questionnaire {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String libelle;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="fk_questionnaire_id",referencedColumnName = "id")
        private List<Category> cat;

        public Questionnaire(Long id, String libelle) {
            this.id = id;
            this.libelle = libelle;
        }

        public Questionnaire() {

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public List<Category> getCat() {
            return cat;
        }

        public void setCat(List<Category> cat) {
            this.cat = cat;
        }
}
