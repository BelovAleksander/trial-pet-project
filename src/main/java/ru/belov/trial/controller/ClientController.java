package ru.belov.trial.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.belov.trial.converter.ClientConverter;
import ru.belov.trial.dto.ClientSaveRequestDto;
import ru.belov.trial.service.validation.ClientService;

import javax.validation.Valid;

@Slf4j
@RequestMapping("web/trial/client")
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientConverter converter;
    private final ClientService clientService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@Valid @RequestBody ClientSaveRequestDto requestDto) {
        log.info("Request to web/trial/client/save: {}", requestDto);
        var clientEntity = converter.toEntity(requestDto);
        clientService.save(clientEntity);
    }
}
