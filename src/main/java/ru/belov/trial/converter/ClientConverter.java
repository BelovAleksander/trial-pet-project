package ru.belov.trial.converter;

import org.springframework.stereotype.Component;
import ru.belov.trial.dto.ClientEsbDto;
import ru.belov.trial.dto.ClientSaveRequestDto;
import ru.belov.trial.entity.ClientEntity;

@Component
public class ClientConverter {

    public ClientEntity toEntity(ClientSaveRequestDto dto) {
        return ClientEntity.builder()
                .active(dto.isActive())
                .clientType(dto.getClientType())
                .name(dto.getName())
                .cityCode(dto.getCityCode())
                .phoneNumber(dto.getPhoneNumber())
                .paymentMethodUuidList(dto.getPaymentMethodUuidList())
                .build();
    }

    //TODO: реализовать, когда возьмусь за шину
    public ClientEsbDto toEventDto(ClientEntity entity) {
        return ClientEsbDto.builder()
                .build();
    }
}
