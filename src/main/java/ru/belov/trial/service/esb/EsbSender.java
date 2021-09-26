package ru.belov.trial.service.esb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.belov.trial.converter.ClientConverter;
import ru.belov.trial.dto.ClientEsbDto;
import ru.belov.trial.entity.ClientEntity;

@Slf4j
@Component
@RequiredArgsConstructor
public class EsbSender {

    private final ClientConverter clientConverter;

    public void send(ClientEntity clientEntity) {
        ClientEsbDto esbEvent = clientConverter.toEventDto(clientEntity);
        log.info("Sending client esb event: {}", esbEvent);
        //TODO: реализовать взаимодействие по шине
    }
}
