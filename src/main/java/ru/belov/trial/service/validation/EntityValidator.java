package ru.belov.trial.service.validation;

import ru.belov.trial.service.validation.meta.Params;

import javax.validation.constraints.NotNull;

public interface EntityValidator<E> {

    void checkData(@NotNull E entity, @NotNull Params params);
}
