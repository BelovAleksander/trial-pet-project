package ru.belov.bookstore.infrastructure.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.bookstore.domain.port.out.CatalogDao;
import ru.belov.bookstore.infrastructure.web.dto.CatalogRequestDto;
import ru.belov.bookstore.infrastructure.web.dto.CatalogResponseDto;

import java.util.List;

@Mapper
public interface CatalogMapper extends CatalogDao {

    List<CatalogResponseDto> getValues(CatalogRequestDto requestDto);
}
