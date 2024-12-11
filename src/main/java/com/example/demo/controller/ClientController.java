package com.example.demo.controller;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.ClientService;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }


    @PostMapping("/clients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Client ajouterClient(@RequestBody Client nouveauClient){
        return this.clientRepository.save(nouveauClient);
    }

    @GetMapping("/clients/{id}")
    public Client afficherClient(@PathVariable int id) throws NotFoundException {
        return this.clientRepository.findById(id).orElseThrow(() -> new NotFoundException("client non trouvé"));
    }

    @PutMapping("/clients/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Client modifierClient(@RequestBody Client clientAModif, @PathVariable int id)
            throws NotFoundException{
        Client c = this.clientRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Client non trouvé"));
        c.setNom(clientAModif.getNom());
        c.setTelephone(clientAModif.getTelephone());
        return this.clientRepository.save(c);
    }

    @DeleteMapping("/clients/{id}")
    public void supprimerClient(@PathVariable int id) throws NotFoundException{
        Client c = this.clientRepository.findById(id).orElseThrow(() -> new
                NotFoundException("Client non trouvé"));
        this.clientRepository.delete(c);
    }
}
