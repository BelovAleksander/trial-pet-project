package ru.belov.bookstore.domain.port.out;

import ru.belov.bookstore.domain.entity.PaymentMethod;

import java.util.UUID;

public interface PaymentMethodDao {

    void save(PaymentMethod paymentMethod);

    boolean exists(PaymentMethod paymentMethod);

    boolean exists(UUID uuid);

    void inactive(UUID uuid);
}
