package com.mycompany.controller;

import com.mycompany.entity.Client;
import com.mycompany.entity.exception.ClientNotFountException;
import com.mycompany.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    public Client saveNewClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFountException(id));
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        newClient.setId(id);
        return clientRepository.save(newClient);
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
