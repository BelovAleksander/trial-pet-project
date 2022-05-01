package ru.belov.bookstore.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class JsonUtil {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public String toJSON(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        } else {
            return OBJECT_MAPPER.writeValueAsString(object);
        }
    }

    public <T> T fromJSON(String json, Class<T> clazz) throws JsonProcessingException {
        if (clazz != null && json != null) {
            return json.isEmpty() ? null : OBJECT_MAPPER.readValue(json, clazz);
        } else {
            return null;
        }
    }
}
