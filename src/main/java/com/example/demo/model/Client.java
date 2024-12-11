package com.example.demo.model;
//Bibliothèque les bdd
import jakarta.persistence.*;
//Annotation JPA entité
@Entity
//Annotation Table
@Table(name = "Client")
public class Client {
    //Annotation qui indique que ce champs est la clé primaire
    @Id
//Annotation qui indique que la clé primaire est créée automatiquement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="client_generator", sequenceName = "client_id_seq")
    private int id;
    //Annotation qui indique que nom est un attribut de la table
    @Column
    private String nom;
    //Idem, attribut
    @Column
    private int telephone;
    //Constructeur vide obligatoire
    public Client(){
    }
    //2e constructeur
    public Client(int id, String nom,int telephone) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
