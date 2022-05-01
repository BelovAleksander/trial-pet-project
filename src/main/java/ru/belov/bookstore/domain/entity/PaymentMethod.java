package ru.belov.bookstore.domain.entity;

import lombok.*;

import java.util.UUID;

@Data
public class PaymentMethod {

    private UUID uuid;
    private UUID clientUuid;
    private String bankAccount;
    private boolean active;
}
