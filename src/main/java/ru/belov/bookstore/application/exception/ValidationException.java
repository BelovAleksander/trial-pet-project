package ru.belov.bookstore.application.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ValidationException extends RuntimeException {

    private final List<String> args;

    public ValidationException(String code, String... args) {
        super(code);
        this.args = args == null ? Collections.emptyList() : List.of(args);
    }
}
