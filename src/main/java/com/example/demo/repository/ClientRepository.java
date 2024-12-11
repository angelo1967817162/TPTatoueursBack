package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Tatoueur;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    List<Client> findByTelephone(int telephone);

}
