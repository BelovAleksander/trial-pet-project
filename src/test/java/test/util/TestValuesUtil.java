package test.util;

import com.github.javafaker.Faker;
import ru.belov.bookstore.application.constant.ClientType;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.entity.LocalizedString;
import ru.belov.bookstore.domain.entity.PaymentMethod;
import ru.belov.bookstore.infrastructure.web.dto.CatalogResponseDto;
import ru.belov.bookstore.infrastructure.web.dto.ClientSaveRequestDto;
import ru.belov.bookstore.infrastructure.web.dto.PaymentMethodDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static ru.belov.bookstore.application.constant.Language.ENG;
import static ru.belov.bookstore.application.constant.Language.RUS;

public class TestValuesUtil {

    private static final Faker FAKER = new Faker();

    public static PaymentMethodDto generatePaymentMethodDto(UUID clientUuid) {
        var paymentMethodDto = new PaymentMethodDto();
        paymentMethodDto.setActive(true);
        paymentMethodDto.setBankAccount(randomCode());
        paymentMethodDto.setClientUuid(clientUuid);
        paymentMethodDto.setUuid(UUID.randomUUID());
        return paymentMethodDto;
    }

    public static PaymentMethod generatePaymentMethod(UUID clientUuid) {
        var paymentMethod = new PaymentMethod();
        paymentMethod.setUuid(UUID.randomUUID());
        paymentMethod.setClientUuid(clientUuid);
        paymentMethod.setActive(true);
        paymentMethod.setBankAccount(randomCode());
        return paymentMethod;
    }

    public static ClientSaveRequestDto generateClientSaveRequestDto() {
        var dto = new ClientSaveRequestDto();
        dto.setClientType(ClientType.UR);
        dto.setRusName(randomCode());
        dto.setEngName(randomCode());
        dto.setActive(true);
        dto.setCityCode(randomCode());
        dto.setPhoneNumber(randomCode());
        dto.setPaymentMethodUuidList(List.of(UUID.randomUUID()));
        return dto;
    }

    public static Client generateClient() {
        var client = new Client();
        client.setUuid(UUID.randomUUID());
        client.setActive(true);
        client.setCityCode(randomCode());
        client.setName(LocalizedString.from(
                Map.of(RUS, randomCode(), ENG, randomCode())
        ));
        client.setPhoneNumber(randomCode());
        client.setClientTypeCode(ClientType.FIZ.getCode());
        client.setPaymentMethodUuidList(List.of(UUID.randomUUID()));
        return client;
    }

    public static CatalogResponseDto generateCatalogResponseDto() {
        var catalog = new CatalogResponseDto();
        catalog.setName(FAKER.harryPotter().location());
        catalog.setCode(randomCode());
        return catalog;
    }

    public static String randomCode() {
        return FAKER.regexify("[1-9]{6}");
    }

    public static String randomName() {
        return FAKER.harryPotter().character();
    }

    public static Integer randomInt() {
        return FAKER.random().nextInt(Integer.MAX_VALUE);
    }
}
