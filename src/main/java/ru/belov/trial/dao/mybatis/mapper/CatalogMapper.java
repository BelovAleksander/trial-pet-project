package ru.belov.trial.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.trial.dao.CatalogDao;
import ru.belov.trial.dto.CatalogRequestDto;
import ru.belov.trial.dto.CatalogResponseDto;

import java.util.List;

@Mapper
public interface CatalogMapper extends CatalogDao {

    List<CatalogResponseDto> getValues(CatalogRequestDto requestDto);
}
