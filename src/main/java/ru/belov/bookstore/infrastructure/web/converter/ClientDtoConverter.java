package ru.belov.bookstore.infrastructure.web.converter;

import org.springframework.stereotype.Component;
import ru.belov.bookstore.application.constant.Language;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.entity.LocalizedString;
import ru.belov.bookstore.infrastructure.web.dto.ClientSaveRequestDto;

import java.util.Map;

@Component
public class ClientDtoConverter {

    public Client toEntity(ClientSaveRequestDto dto) {
        return Client.builder()
                .active(dto.getActive())
                .clientTypeCode(dto.getClientType().getCode())
                .name(toLocalizedString(dto.getRusName(), dto.getEngName()))
                .cityCode(dto.getCityCode())
                .phoneNumber(dto.getPhoneNumber())
                .paymentMethodUuidList(dto.getPaymentMethodUuidList())
                .build();
    }

    private LocalizedString toLocalizedString(String rusName, String engName) {
        return LocalizedString.from(Map.of(Language.RUS, rusName, Language.ENG, engName));
    }
}
