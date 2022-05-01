package ru.belov.bookstore.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.bookstore.application.constant.ExceptionMessage;
import ru.belov.bookstore.application.constant.OrderBy;
import ru.belov.bookstore.application.constant.SortOrder;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Транспорт для запроса полей каталога")
public class CatalogRequestDto extends CommonDto {

    @NotBlank(message = ExceptionMessage.CATALOG_NAME_EMPTY)
    @Schema(description = "Наименование каталога", example = "city", required = true)
    private String catalogName;
    @Schema(description = "Максимальное число возвращаемых значений", example = "10")
    private Integer limit;
    @Schema(description = "Сдвиг относительно первого значения каталога", example = "0")
    private Integer offset;
    @Schema(description = "Сортировка (с начала/конца)", example = "ASC", required = true)
    private SortOrder sortOrder;
    @Schema(description = "Сортировка (по какому значению)", example = "NAME", required = true)
    private OrderBy orderBy;
}
