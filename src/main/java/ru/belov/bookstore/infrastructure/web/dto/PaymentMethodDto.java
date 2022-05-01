package ru.belov.bookstore.infrastructure.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.belov.bookstore.application.constant.ExceptionMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentMethodDto extends CommonDto {
    private UUID uuid;
    @NotNull(message = ExceptionMessage.CLIENT_UUID_IS_NULL)
    private UUID clientUuid;
    @NotBlank(message = ExceptionMessage.BANK_ACCOUNT_IS_EMPTY)
    private String bankAccount;
    private boolean active;
}
