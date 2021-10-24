package ru.belov.trial.infrastructure;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class JsonLocalizedStringSerializer extends JsonSerializer<LocalizedString> {

    @Override
    public void serialize(LocalizedString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getStrings());
    }
}
