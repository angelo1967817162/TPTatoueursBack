package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="role_generator", sequenceName = "role_id_seq")
    private int id;
    @Column
    private String name;



    public void setName(String name) {
        this.name = name;
    }

    public Role() {

    }


    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Role(int id) {
        this.id = id;
    }
}