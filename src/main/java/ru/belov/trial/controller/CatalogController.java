package ru.belov.trial.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.belov.trial.dto.CatalogRequestDto;
import ru.belov.trial.dto.CatalogResponseDto;
import ru.belov.trial.dto.CollectionWrapperResponseDto;
import ru.belov.trial.service.validation.CatalogService;

import javax.validation.Valid;

@Slf4j
@RequestMapping("web/trial/catalog")
@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "getValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionWrapperResponseDto<CatalogResponseDto> getValues(@Valid @RequestBody CatalogRequestDto requestDto) {
        log.debug("Request to web/trial/catalog/getValues: {}", requestDto);
        var response = new CollectionWrapperResponseDto<CatalogResponseDto>();
        var items = catalogService.getValues(requestDto);
        response.setItems(items);
        return response;
    }
}
