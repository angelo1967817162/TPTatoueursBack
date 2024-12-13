package com.example.demo.repository;

import com.example.demo.model.Projet;
import com.example.demo.model.Tatoueur;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {

    List<Projet> findByStyle(String description);


}