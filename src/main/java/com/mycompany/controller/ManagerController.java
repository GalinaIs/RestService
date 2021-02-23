package com.mycompany.controller;

import com.mycompany.entity.Manager;
import com.mycompany.entity.exception.ManagerNotFountException;
import com.mycompany.repository.ManagerRepository;
import com.mycompany.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @PostMapping("/managers")
    public Manager saveNewManager(@RequestBody Manager manager) {
        return managerService.saveNewManager(manager);
    }

    @GetMapping("/managers/{id}")
    public Manager getManager(@PathVariable Long id) {
        return managerService.getManager(id);
    }

    @PutMapping("/managers/{id}")
    public Manager updateManager(@RequestBody Manager newManager, @PathVariable Long id) {
        return managerService.updateManager(newManager, id);
    }

    @DeleteMapping("/managers/{id}")
    public void deleteClient(@PathVariable Long id) {
        managerService.deleteClient(id);
    }
}
