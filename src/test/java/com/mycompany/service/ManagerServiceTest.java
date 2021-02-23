package com.mycompany.service;

import com.mycompany.entity.Client;
import com.mycompany.entity.Manager;
import com.mycompany.entity.exception.ClientNotFountException;
import com.mycompany.repository.ClientRepository;
import com.mycompany.repository.ManagerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.main.banner-mode=off",
        "spring.datasource.platform=h2",
        "spring.jpa.hibernate.ddl-auto=none"
})
class ManagerServiceTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ManagerRepository managerRepository;

    @Test
    void getAllManagers() {
        ManagerService managerService = new ManagerService(managerRepository);
        Assert.assertEquals(2, managerService.getAllManagers().size());
    }

    @Test
    void deleteManager() {
        ManagerService managerService = new ManagerService(managerRepository);
        long managerId = 1L;
        Set<Client> allClientsByManagerId = managerService.getAllClientsByManagerId(managerId);
        Assert.assertFalse(allClientsByManagerId.isEmpty());
        managerService.deleteClient(managerId);
        // проверяем, что после удаления менеджера клиенты не удалены из БД
        allClientsByManagerId.forEach(
                client -> clientRepository.findById(client.getId())
                        .orElseThrow(() -> new ClientNotFountException(client.getId()))
        );
    }
}