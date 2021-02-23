package com.mycompany.service;

import com.mycompany.entity.Client;
import com.mycompany.entity.exception.ClientNotFountException;
import com.mycompany.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client saveNewClient(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFountException(id));
    }

    public Client updateClient(Client newClient, Long id) {
        newClient.setId(id);
        return clientRepository.save(newClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
