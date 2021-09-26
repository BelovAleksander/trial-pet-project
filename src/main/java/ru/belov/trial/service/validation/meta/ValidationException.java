package ru.belov.trial.service.validation.meta;

public class ValidationException extends RuntimeException {

    public ValidationException(String code) {
        super(code);
    }
}
