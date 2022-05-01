package ru.belov.bookstore.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private UUID uuid;
    private boolean active;
    private LocalizedString name;
    private String cityCode;
    private String clientTypeCode;
    private String phoneNumber;
    private List<UUID> paymentMethodUuidList;
}
