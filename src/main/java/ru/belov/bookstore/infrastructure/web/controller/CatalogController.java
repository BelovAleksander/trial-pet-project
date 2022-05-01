package ru.belov.bookstore.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.belov.bookstore.domain.port.out.CatalogDao;
import ru.belov.bookstore.infrastructure.web.dto.CatalogRequestDto;
import ru.belov.bookstore.infrastructure.web.dto.CatalogResponseDto;
import ru.belov.bookstore.infrastructure.web.dto.CollectionWrapperResponseDto;

import javax.validation.Valid;

@Slf4j
@RequestMapping(CatalogController.BASE_URI)
@RestController
@RequiredArgsConstructor
public class CatalogController {

    protected static final String BASE_URI = "/web/bookstore/catalog";
    private final CatalogDao catalogDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "getValues", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionWrapperResponseDto<CatalogResponseDto> getValues(@Valid @RequestBody CatalogRequestDto requestDto) {
        log.debug("Request to web/bookstore/catalog/getValues: {}", requestDto);
        var items = catalogDao.getValues(requestDto);
        var response = new CollectionWrapperResponseDto<CatalogResponseDto>();
        response.setItems(items);
        return response;
    }
}
