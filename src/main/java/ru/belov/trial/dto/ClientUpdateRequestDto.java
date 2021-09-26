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
    @Schema(description = "UUID клиента", example = "", required = true)
    private UUID uuid;
}
