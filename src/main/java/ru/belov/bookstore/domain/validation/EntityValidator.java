package ru.belov.bookstore.domain.validation;

import ru.belov.bookstore.domain.validation.meta.Params;

import javax.validation.constraints.NotNull;

public interface EntityValidator<E> {

    void checkData(@NotNull E entity, @NotNull Params params);
}
