package com.mycompany.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mycompany.entity.Manager;

import java.io.IOException;

public class CustomManagerSerializerForClient extends JsonSerializer<Manager> {
    @Override
    public void serialize(Manager value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("surname", value.getSurname());
        gen.writeStringField("name", value.getName());
        gen.writeStringField("patronymic", value.getPatronymic());
        gen.writeStringField("phoneNumber", value.getPhoneNumber());
        gen.writeStringField("deputyId", String.valueOf(value.getDeputyId()));
        gen.writeEndObject();

    }
}
