package com.mycompany.config;

import com.mycompany.entity.Client;
import com.mycompany.entity.Manager;
import com.mycompany.repository.ClientRepository;
import com.mycompany.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initClientDatabase(ClientRepository repository) {
        return args -> {
            log.info("Preloading client " + repository.save(new Client("Company number 1", "address1")));
            log.info("Preloading client " + repository.save(new Client("Company number 2", "address2")));
        };
    }

    @Bean
    CommandLineRunner initManagerDatabase(ManagerRepository repository) {
        return args -> {
            log.info("Preloading manager " + repository.save(new Manager("Surname1", "Name1", "Patronymic1", "111-11-11")));
            log.info("Preloading manager " + repository.save(new Manager("Surname2", "Name2", "Patronymic2", "222-22-22")));
        };
    }
}
