package com.mycompany.service;

import com.mycompany.entity.Client;
import com.mycompany.entity.Manager;
import com.mycompany.entity.exception.ManagerNotFountException;
import com.mycompany.repository.ManagerRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
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
        managerRepository.deleteById(id);
    }

    public Set<Client> getAllClientsByManagerId(Long id) {
        Manager manager = getManager(id);
        return manager.getClients();
    }
}
