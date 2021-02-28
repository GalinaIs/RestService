package com.mycompany.service;

import com.mycompany.entity.Client;
import com.mycompany.entity.Manager;
import com.mycompany.entity.exception.ManagerNotFountException;
import com.mycompany.repository.ManagerRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final ClientService clientService;

    public ManagerService(ManagerRepository managerRepository, ClientService clientService) {
        this.managerRepository = managerRepository;
        this.clientService = clientService;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager saveNewManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager getManager(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFountException(id));
    }

    public Manager updateManager(Manager newManager, Long id) {
        newManager.setId(id);
        return managerRepository.save(newManager);
    }

    public void deleteClient(Long id) {
        Manager manager = getManager(id);
        if (manager.getDeputyId() != null) {
            manager.getClients().forEach(client -> {
                client.setManager(manager.getDeputy());
                clientService.updateClient(client, client.getId());
            });
        }
        managerRepository.deleteById(id);
    }

    public Set<Client> getAllClientsByManagerId(Long id) {
        Manager manager = getManager(id);
        return manager.getClients();
    }
}
