package ru.belov.trial.service.validation;

import ru.belov.trial.service.validation.meta.Params;

public interface EntityValidator<E> {

    void checkData(E entity, Params params);
}
