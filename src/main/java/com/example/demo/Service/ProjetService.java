package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.model.Projet;
import com.example.demo.model.Tatoueur;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TatoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    // Obtenir tous les tatoueurs ou filtrer par style
    public List<Projet> getProjets(String description) {
        if (description != null) {
            return projetRepository.findByDescription(description);
        } else {
            return projetRepository.findAll();
        }//test
    }
    // Ajouter un nouveau tatoueur
    public Projet ajouterProjet(Projet nouveauProjet) {
        return projetRepository.save(nouveauProjet);
    }
    // Afficher un tatoueur par ID
    public Projet afficherProjet(int id) throws NotFoundException {
        return projetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tatoueur non trouvé"));
    }
    // Modifier un tatoueur existant
    public Projet modifierProjet(int id, Projet tatoueurAModif) throws NotFoundException {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tatoueur non trouvé"));
        projet.setNom(tatoueurAModif.getNom());
        projet.setDescription(tatoueurAModif.getDescription());
        return projetRepository.save(projet);
    }
    // Supprimer un tatoueur
    public void supprimerProjet(int id) throws NotFoundException {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tatoueur non trouvé"));
        projetRepository.delete(projet);
    }

}
