package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.trial.constant.ExceptionMessage;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для редактирования отчета")
public class ClientUpdateRequestDto extends ClientSaveRequestDto {

    @NotNull(message = ExceptionMessage.CLIENT_UUID_IS_NULL)
    @Schema(description = "UUID клиента", example = "a1adc05a-d47d-4397-bc69-2a938a3907ce", required = true)
    private UUID uuid;
}
