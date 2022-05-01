package ru.belov.bookstore.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.bookstore.application.constant.ClientType;
import ru.belov.bookstore.application.constant.ExceptionMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Транспорт для создания клиента")
public class ClientSaveRequestDto extends CommonDto {

    @NotNull(message = ExceptionMessage.CLIENT_ACTIVE_FLAG_IS_NULL)
    @Schema(description = "Флаг активности клиента", example = "true", required = true)
    private Boolean active;

    @NotBlank(message = ExceptionMessage.CLIENT_ENG_NAME_IS_EMPTY)
    @Schema(description = "Наименование клиента", example = "Petr", required = true)
    private String engName;

    @NotBlank(message = ExceptionMessage.CLIENT_RUS_NAME_IS_EMPTY)
    @Schema(description = "Наименование клиента", example = "Петр", required = true)
    private String rusName;

    @Schema(description = "Список UUID привязанных методов оплаты",
            example = "[ \"a1adc05a-d47d-4397-bc69-2a938a3907ce\", \"7cb0a38c-4bfd-438c-a5ce-4882ecb6248d\"]")
    private List<UUID> paymentMethodUuidList;

    @NotBlank(message = ExceptionMessage.CLIENT_CITY_CODE_IS_EMPTY)
    @Schema(description = "Код города", example = "1", required = true)
    private String cityCode;

    @NotNull(message = ExceptionMessage.CLIENT_TYPE_IS_NULL)
    @Schema(description = "Тип клиента", example = "UR", required = true, allowableValues = "UR, FIZ")
    private ClientType clientType;

    @NotBlank(message = ExceptionMessage.CLIENT_PHONE_IS_EMPTY)
    @Schema(description = "Номер телефона", example = "89134445566", required = true, minLength = 11, maxLength = 11)
    private String phoneNumber;
}
