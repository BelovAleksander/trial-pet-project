package ru.belov.bookstore.infrastructure.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.belov.bookstore.domain.entity.LocalizedString;

import java.io.IOException;

public class JsonLocalizedStringSerializer extends JsonSerializer<LocalizedString> {

    @Override
    public void serialize(LocalizedString value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(value.getStrings());
    }
}
