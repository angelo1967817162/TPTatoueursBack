package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    // Obtenir tous les tatoueurs ou filtrer par style
    public List<Client> getClients() {

            return clientRepository.findAll();

    }
    // Ajouter un nouveau tatoueur
    public Client ajouterClient(Client nouveauClient) {
        return clientRepository.save(nouveauClient);
    }
    // Afficher un tatoueur par ID
    public Client afficherClient(int id) throws NotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client non trouvé"));
    }
    // Modifier un tatoueur existant
    public Client modifierClient(int id, Client clientAModif) throws NotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client non trouvé"));
        client.setNom(clientAModif.getNom());
        client.setTelephone(clientAModif.getTelephone());
        return clientRepository.save(client);
    }
    // Supprimer un tatoueur
    public void supprimerClient(int id) throws NotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client non trouvé"));
        clientRepository.delete(client);
    }

}
