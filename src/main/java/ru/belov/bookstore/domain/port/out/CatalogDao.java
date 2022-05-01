package ru.belov.bookstore.domain.port.out;

import ru.belov.bookstore.infrastructure.web.dto.CatalogRequestDto;
import ru.belov.bookstore.infrastructure.web.dto.CatalogResponseDto;

import java.util.List;

public interface CatalogDao {

    List<CatalogResponseDto> getValues(CatalogRequestDto requestDto);
}
