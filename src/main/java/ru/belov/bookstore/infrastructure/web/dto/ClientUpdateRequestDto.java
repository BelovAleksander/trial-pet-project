package ru.belov.bookstore.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.bookstore.application.constant.ExceptionMessage;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Транспорт для редактирования клиента")
public class ClientUpdateRequestDto extends ClientSaveRequestDto {

    @NotNull(message = ExceptionMessage.CLIENT_UUID_IS_NULL)
    @Schema(description = "UUID клиента", example = "a1adc05a-d47d-4397-bc69-2a938a3907ce", required = true)
    private UUID uuid;
}
