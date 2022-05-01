package ru.belov.bookstore.infrastructure.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.belov.bookstore.application.constant.Language;
import ru.belov.bookstore.domain.entity.LocalizedString;

import java.io.IOException;
import java.util.Map;

public class JsonLocalizedStringDeserializer extends JsonDeserializer<LocalizedString> {

    private static final TypeReference<Map<Language, String>> TYPE_REFERENCE = new TypeReference<>() {
    };

    @Override
    public LocalizedString deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalizedString.from(p.readValueAs(TYPE_REFERENCE));
    }
}
