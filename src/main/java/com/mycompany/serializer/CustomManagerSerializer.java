package com.mycompany.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mycompany.entity.Manager;

import java.io.IOException;

public class CustomManagerSerializer extends JsonSerializer<Manager> {
    @Override
    public void serialize(Manager value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("surname", value.getSurname());
        gen.writeStringField("name", value.getName());
        gen.writeStringField("patronymic", value.getPatronymic());
        gen.writeStringField("phoneNumber", value.getPhoneNumber());
        if (value.getDeputy() == null) {
            gen.writeNullField("deputy");
        } else {
            writeDeputyInfo(value.getDeputy(), gen);
        }
        gen.writeEndObject();

    }

    private static void writeDeputyInfo(Manager deputy, JsonGenerator gen) throws IOException {
        gen.writeFieldName("deputy");
        gen.writeStartObject();
        gen.writeStringField("surname", deputy.getSurname());
        gen.writeStringField("name", deputy.getName());
        gen.writeStringField("patronymic", deputy.getPatronymic());
        gen.writeStringField("phoneNumber", deputy.getPhoneNumber());
        gen.writeEndObject();
    }
}
