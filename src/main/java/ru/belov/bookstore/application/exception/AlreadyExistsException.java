package ru.belov.bookstore.application.exception;

import ru.belov.bookstore.domain.entity.PaymentMethod;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(PaymentMethod paymentMethod) {
        super(String.format("Payment method of client [%s] with bank account [%s] is already exists",
                paymentMethod.getClientUuid(), paymentMethod.getBankAccount()));
    }
}
