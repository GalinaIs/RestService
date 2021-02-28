package com.mycompany.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mycompany.entity.Manager;
import com.mycompany.serializer.CustomManagerSerializer;
import com.mycompany.serializer.CustomManagerSerializerForClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Manager.class, new CustomManagerSerializer());
        module.addSerializer(Manager.class, new CustomManagerSerializerForClient());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
