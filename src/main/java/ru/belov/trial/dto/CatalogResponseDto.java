package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для возврата полей каталога")
public class CatalogResponseDto extends CommonDto {

    @Schema(description = "Наименование поля каталога", example = "Москва")
    private String name;

    @Schema(description = "Код каталога", example = "1")
    private String code;
}
