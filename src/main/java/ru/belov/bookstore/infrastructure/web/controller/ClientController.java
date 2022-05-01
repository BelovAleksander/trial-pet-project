package ru.belov.bookstore.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.belov.bookstore.infrastructure.web.converter.ClientDtoConverter;
import ru.belov.bookstore.infrastructure.web.dto.ClientSaveRequestDto;
import ru.belov.bookstore.domain.usecase.SaveClientUseCase;

import javax.validation.Valid;

@Slf4j
@RequestMapping(ClientController.BASE_URI)
@RestController
@RequiredArgsConstructor
public class ClientController {
    protected static final String BASE_URI = "/web/bookstore/client";

    private final ClientDtoConverter converter;
    private final SaveClientUseCase saveClientUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@Valid @RequestBody ClientSaveRequestDto requestDto) {
        log.info("Request to web/bookstore/client/save: {}", requestDto);
        var clientEntity = converter.toEntity(requestDto);
        saveClientUseCase.process(clientEntity);
    }
}
