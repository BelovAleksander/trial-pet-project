package ru.belov.bookstore.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Транспорт для возврата коллекции объектов")
public class CollectionWrapperResponseDto<E> extends CommonDto {

    @Schema(description = "Коллекция объектов")
    private List<E> items;

}
