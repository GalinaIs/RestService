package com.mycompany.service;

import com.mycompany.entity.Client;
import com.mycompany.repository.ClientRepository;
import com.mycompany.repository.ManagerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.main.banner-mode=off",
        "spring.datasource.platform=h2",
        "spring.jpa.hibernate.ddl-auto=none"
})
class ClientServiceTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ManagerRepository managerRepository;

    @Test
    void getAllClients() {
        ClientService clientService = new ClientService(clientRepository);
        Assert.assertEquals(3, clientService.getAllClients().size());
    }

    @Test
    void deleteClient() {
        ClientService clientService = new ClientService(clientRepository);
        long clientId = 3L;
        Client client = clientService.getClient(clientId);
        Long managerId = client.getManager().getId();
        Assert.assertNotNull(managerRepository.findById(managerId));
        clientService.deleteClient(clientId);
        // проверяем, что после удаления клиента менеджер не удален
        Assert.assertNotNull(managerRepository.findById(managerId));
    }
}