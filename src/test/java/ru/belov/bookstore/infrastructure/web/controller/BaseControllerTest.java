package ru.belov.bookstore.infrastructure.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//FIXME: реализовать @ControllerAdvice
public class BaseControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    protected String asJsonString(final Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> T fromJsonString(String str, TypeReference<T> typeReference) throws JsonProcessingException {
        return MAPPER.readValue(str, typeReference);
    }
}
