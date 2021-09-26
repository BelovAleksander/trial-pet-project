package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.constant.ExceptionMessage;
import ru.belov.trial.constant.Language;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспорт для создания отчета")
public class ClientSaveRequestDto extends CommonDto {

    @NotNull(message = ExceptionMessage.CLIENT_ACTIVE_FLAG_IS_NULL)
    @Schema(description = "Флаг активности клиента", example = "true", required = true)
    private boolean active;

    @NotNull(message = ExceptionMessage.CLIENT_NAME_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_NAME_IS_EMPTY)
    @Schema(description = "Наименование клиента", example = "{ \"RUS\": \"Петр\", \"ENG\": \"Petr\"}", required = true)
    private Map<Language, String> name;

    @Schema(description = "Список UUID привязанных методов оплаты", example = "[ \"\", \"\"]")
    private List<UUID> paymentMethodUuidList;

    @NotNull(message = ExceptionMessage.CLIENT_CITY_CODE_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_CITY_CODE_IS_EMPTY)
    @Schema(description = "Код города", example = "12345", required = true)
    private String cityCode;

    @NotNull(message = ExceptionMessage.CLIENT_TYPE_IS_NULL)
    @Schema(description = "Тип клиента", example = "UR", required = true, allowableValues = "UR, FIZ")
    private ClientType clientType;

    @NotNull(message = ExceptionMessage.CLIENT_PHONE_IS_NULL)
    @NotEmpty(message = ExceptionMessage.CLIENT_PHONE_IS_EMPTY)
    @Pattern(message = ExceptionMessage.CLIENT_PHONE_INVALID, regexp = "^\\d{11}$")
    @Schema(description = "Номер телефона", example = "89134445566", required = true, minLength = 11, maxLength = 11)
    private String phoneNumber;
}
