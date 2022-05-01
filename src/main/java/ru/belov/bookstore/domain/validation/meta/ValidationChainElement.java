package ru.belov.bookstore.domain.validation.meta;

import ru.belov.bookstore.application.exception.ValidationException;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public interface ValidationChainElement<E, F> {

    void apply(@NotNull E data, @NotNull F params);

    default void fail(@NotNull String msg, @Nullable String... args) {
        throw new ValidationException(msg, args);
    }
}
