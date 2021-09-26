package ru.belov.trial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.constant.Language;

import java.util.List;
import java.util.Map;
import java.util.UUID;

//TODO: перенести в клиентскую либу

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEsbDto {

    @Schema(description = "UUID клиента", example = "", required = true)
    private UUID uuid;

    @Schema(description = "Флаг активности клиента", example = "true", required = true)
    private boolean active;

    @Schema(description = "Наименование клиента", example = "{ \"RUS\": \"Петр\", \"ENG\": \"Petr\"}", required = true)
    private Map<Language, String> name;

    @Schema(description = "Список UUID привязанных методов оплаты", example = "[ \"\", \"\"]")
    private List<UUID> paymentMethodUuidList;

    @Schema(description = "Код города", example = "12345", required = true)
    private String cityCode;

    @Schema(description = "Тип клиента", example = "UR", required = true, allowableValues = "UR, FIZ")
    private ClientType clientType;

    @Schema(description = "Номер телефона", example = "89134445566", required = true, minLength = 11, maxLength = 11)
    private String phoneNumber;
}
