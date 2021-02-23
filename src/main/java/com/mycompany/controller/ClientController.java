package com.mycompany.controller;

import com.mycompany.entity.Client;
import com.mycompany.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "clients")
@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        log.info("Получен запрос на предоставлении информации обо всех клиентах");
        List<Client> allClients = clientService.getAllClients();
        log.info("Получен список всех клиентов {}", allClients);
        return allClients;
    }

    @PostMapping("/clients")
    public Client saveNewClient(@RequestBody Client client) {
        log.info("Получен запрос на добавление нового клиента {}", client);
        Client newClient = clientService.saveNewClient(client);
        log.info("Клиент успешно добавлен {}", newClient);
        return newClient;
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        log.info("Получен запрос на предоставлении информации о клиенте с id {}", id);
        Client client = clientService.getClient(id);
        log.info("По id {} найден клиент {}", id, client);
        return client;
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        log.info("Получен запрос на обновление клиента с id {}", id);
        Client clientAfterSaving = clientService.updateClient(newClient, id);
        log.info("Данные по клиенту обновлены {}", clientAfterSaving);
        return clientAfterSaving;
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        log.info("Получен запрос на удаление клиента с id {}", id);
        clientService.deleteClient(id);
        log.info("Клиента с id {} успешно удален", id);
    }
}
