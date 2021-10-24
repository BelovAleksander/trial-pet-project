package ru.belov.trial.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String toJSON(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        } else {
            return jsonMapper.writeValueAsString(object);
        }
    }

    public static <T> T fromJSON(String json, Class<T> clazz) throws JsonProcessingException {
        if (clazz != null && json != null) {
            return json.isEmpty() ? null : jsonMapper.readValue(json, clazz);
        } else {
            return null;
        }
    }
}
