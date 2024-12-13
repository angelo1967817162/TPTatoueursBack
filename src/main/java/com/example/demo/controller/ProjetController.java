package com.example.demo.controller;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.ProjetService;
import com.example.demo.Service.TatoueurService;
import com.example.demo.model.Client;
import com.example.demo.model.Projet;
import com.example.demo.model.Tatoueur;
import com.example.demo.repository.ProjetRepository;
import com.example.demo.repository.TatoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@CrossOrigin
public class ProjetController {
    @Autowired
    private ProjetRepository projetRepository;


    @Autowired
    private ProjetService projetService;
    @GetMapping("/projets")
    public List<Projet> getProejts() {
        return projetService.getProjets();
    }


    @PostMapping("/projets")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Projet ajouterProjet(@RequestBody Projet nouveauProjet){
        return this.projetRepository.save(nouveauProjet);
    }

    @GetMapping("/projets/{id}")
    public Projet afficherProjet(@PathVariable int id) throws NotFoundException {
        return this.projetRepository.findById(id).orElseThrow(() -> new NotFoundException("Tatoueur non trouvé"));
    }

    @PutMapping("/projets/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Projet modifierProjet(@RequestBody Projet projetAModif, @PathVariable int id)
            throws NotFoundException{
        Projet t = this.projetRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Tatoueur non trouvé"));
        t.setNom(projetAModif.getNom());
        t.setDescription(projetAModif.getDescription());
        return this.projetRepository.save(t);
    }

    @DeleteMapping("/projets/{id}")
    public void supprimerProjet(@PathVariable int id) throws NotFoundException{
        Projet t = this.projetRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Projet non trouvé"));
        this.projetRepository.delete(t);
    }
}



