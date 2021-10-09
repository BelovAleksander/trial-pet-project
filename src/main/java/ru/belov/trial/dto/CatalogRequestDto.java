package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.constant.ExceptionMessage;
import ru.belov.trial.constant.OrderBy;
import ru.belov.trial.constant.SortOrder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для запроса полей каталога")
public class CatalogRequestDto extends CommonDto {

    @NotNull(message = ExceptionMessage.CATALOG_NAME_EMPTY)
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
