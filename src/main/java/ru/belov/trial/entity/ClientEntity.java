package ru.belov.trial.entity;

import lombok.*;
import ru.belov.trial.constant.ClientType;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    private UUID uuid;
    private boolean active;
    private String name;
    private List<UUID> paymentMethodUuidList;
    private String cityCode;
    private String clientTypeCode;
    private String phoneNumber;
}
