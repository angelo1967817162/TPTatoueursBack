package com.example.demo.model;
//Bibliothèque les bdd
import jakarta.persistence.*;
//Annotation JPA entité
@Entity
//Annotation Table
@Table(name = "Projet")
public class Projet {
    //Annotation qui indique que ce champs est la clé primaire
    @Id
//Annotation qui indique que la clé primaire est créée automatiquement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="projet_generator", sequenceName = "projet_id_seq")
    private int id;
    //Annotation qui indique que nom est un attribut de la table
    @Column
    private String nom;
    //Idem, attribut
    @Column
    private String description;
    //Constructeur vide obligatoire
    public Projet(){
    }
    //2e constructeur
    public Projet(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
       this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
