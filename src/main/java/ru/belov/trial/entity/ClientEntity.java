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
public class ClientEntity {

    private UUID uuid;
    private boolean active;
    private Map<Language, String> name;
    private List<UUID> paymentMethodUuidList;
    private String cityCode;
    private ClientType clientType;
    private String phoneNumber;
}
