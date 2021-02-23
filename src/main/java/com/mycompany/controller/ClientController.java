package com.mycompany.controller;

import com.mycompany.entity.Client;
import com.mycompany.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/clients")
    public Client saveNewClient(@RequestBody Client client) {
        return clientService.saveNewClient(client);
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        return clientService.updateClient(newClient, id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
