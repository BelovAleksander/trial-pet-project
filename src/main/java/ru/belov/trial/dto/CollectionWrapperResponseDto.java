package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для возврата коллекции объектов")
public class CollectionWrapperResponseDto<E> extends CommonDto {

    @Schema(description = "Коллекция объектов")
    private List<E> items;

}
