package ru.belov.trial.service.validation.meta;

import ru.belov.trial.constant.ExceptionMessage;

import javax.validation.constraints.NotNull;

public interface ValidationChainElement<E, F> {

    void apply(@NotNull E data, @NotNull F params);

    default void fail(@NotNull String msg) {
        throw new ValidationException(msg);
    }
}
