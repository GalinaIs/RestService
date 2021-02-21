package com.mycompany.controller;

import com.mycompany.entity.Manager;
import com.mycompany.entity.exception.ManagerNotFountException;
import com.mycompany.repository.ManagerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @PostMapping("/managers")
    public Manager saveNewManager(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @GetMapping("/managers/{id}")
    public Manager getManager(@PathVariable Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFountException(id));
    }

    @PutMapping("/managers/{id}")
    public Manager updateManager(@RequestBody Manager newManager, @PathVariable Long id) {
        newManager.setId(id);
        return managerRepository.save(newManager);
    }

    @DeleteMapping("/managers/{id}")
    void deleteClient(@PathVariable Long id) {
        managerRepository.deleteById(id);
    }
}
