package com.example.demo.controller;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.TatoueurService;
import com.example.demo.model.Tatoueur;
import com.example.demo.repository.TatoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//import java.util.Arrays;
import java.util.List;



@RestController
@CrossOrigin
public class TatoueurController {
    @Autowired
    private TatoueurRepository tatoueurRepository;

    /*@GetMapping("/tatoueurs")
    public List<Tatoueur> getTatoueurs(@RequestParam(required = false) String style) {
        if(style!=null){
            return this.tatoueurRepository.findByStyle(style);
        }else{
            return this.tatoueurRepository.findAll();
        }
    }*/
    @Autowired
    private TatoueurService tatoueurService;
    @GetMapping("/tatoueurs")
    public List<Tatoueur> getTatoueurs(@RequestParam(required = false) String style) {
        return tatoueurService.getTatoueurs(style);
    }
/*@PostMapping("/tatoueurs")
public List<Tatoueur> ajouterTatoueur(@RequestBody Tatoueur nouveauTatoueur){
    this.listeTatoueurs.add(nouveauTatoueur);
    return listeTatoueurs;
}*/

    /*@GetMapping("/tatoueurs")
    public List<Tatoueur> getTatoueurs() {
        return this.listeTatoueurs;
    }*/
   /* @GetMapping("/tatoueurs")
    public List<Tatoueur> getTatoueurs() {
        return this.tatoueurRepository.findAll();
    }*/
    /*@GetMapping("/tatoueurs/{id}")
    public Tatoueur afficherTatoueur(@PathVariable int id) {
//Cherchez le tatoueur ou la tatoueuse dans votre liste et retourner l’objet trouvé.
        //faire un foreach sur listeTatoueurs
        //Pour chaque Tatoueur dans chaque case, vérifiez si getId==id
        // si oui, retrouver le tatoueur
        for (Tatoueur t: this.listeTatoueurs){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    @PutMapping("/tatoueurs/{id}")
    public void modifierTatoueur(@RequestBody Tatoueur tatoueurAModif, @PathVariable int id) {
        //parourir la liste, utiliser la fonction set
        for (int i = 0; i < this.listeTatoueurs.size(); i++) {
            if (this.listeTatoueurs.get(i).getId() == id) {
                this.listeTatoueurs.set(i, tatoueurAModif);
            }
        }
// autre manière de faire le @PutMapping
       /* for(Tatoueur t : this.listeTatoueurs){
            if(t.getId()==id){
                t.setNom(tatoueurAModif.getNom());
                t.setStyle(tatoueurAModif.getStyle());
            }
        }

    }
        @DeleteMapping("/tatoueurs/{id}")
        public void supprimerTatoueur(@PathVariable int id) {
            for (int i = 0; i < this.listeTatoueurs.size(); i++) {
                if (this.listeTatoueurs.get(i).getId() == id) {
                    this.listeTatoueurs.remove(i);
                }

            }
        }

        @DeleteMapping("/tatoueurs")
        public void supprimerTatoueur() {
                //Supprime tout
                //liste.
            this.listeTatoueurs.clear();
            }
*/

    @PostMapping("/tatoueurs")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Tatoueur ajouterTatoueur(@RequestBody Tatoueur nouveauTatoueur){
        return this.tatoueurRepository.save(nouveauTatoueur);
    }

    @GetMapping("/tatoueurs/{id}")
    public Tatoueur afficherTatoueur(@PathVariable int id) throws NotFoundException {
        return this.tatoueurRepository.findById(id).orElseThrow(() -> new NotFoundException("Tatoueur non trouvé"));
    }

    @PutMapping("/tatoueurs/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Tatoueur modifierTatoueur(@RequestBody Tatoueur tatoueurAModif, @PathVariable int id)
            throws NotFoundException{
        Tatoueur t = this.tatoueurRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Tatoueur non trouvé"));
        t.setNom(tatoueurAModif.getNom());
        t.setStyle(tatoueurAModif.getStyle());
        return this.tatoueurRepository.save(t);
    }

    @DeleteMapping("/tatoueurs/{id}")
    public void supprimerTatoueur(@PathVariable int id) throws NotFoundException{
        Tatoueur t = this.tatoueurRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Tatoueur non trouvé"));
        this.tatoueurRepository.delete(t);
    }
}



