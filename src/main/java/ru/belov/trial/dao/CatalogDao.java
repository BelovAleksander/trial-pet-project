package ru.belov.trial.dao;

import ru.belov.trial.dto.CatalogRequestDto;
import ru.belov.trial.dto.CatalogResponseDto;

import java.util.List;

public interface CatalogDao {

    List<CatalogResponseDto> getValues(CatalogRequestDto requestDto);
}
