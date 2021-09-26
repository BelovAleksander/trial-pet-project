package ru.belov.trial.service.validation.meta;

import ru.belov.trial.constant.ExceptionMessage;

public interface ValidationChainElement<E, F> {

    void apply(E data, F params);

    default void fail(String msg) {
        throw new ValidationException(msg);
    }
}
