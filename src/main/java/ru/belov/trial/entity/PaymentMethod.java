package ru.belov.trial.entity;

import lombok.*;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.constant.Language;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    private UUID uuid;
    private String bankAccount;
    private boolean active;
}
