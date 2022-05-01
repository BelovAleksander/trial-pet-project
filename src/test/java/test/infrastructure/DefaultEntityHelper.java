package test.infrastructure;

import org.springframework.stereotype.Component;
import ru.belov.bookstore.application.constant.ClientType;
import ru.belov.bookstore.domain.entity.LocalizedString;
import test.model.ClientG;

import java.util.UUID;

import static ru.belov.bookstore.application.constant.Language.RUS;
import static test.util.TestValuesUtil.randomCode;
import static test.util.TestValuesUtil.randomName;

/**
 * Создание и насыщение моделей дефолтными значениями
 */
@Component
public class DefaultEntityHelper {

    public ClientG createClient(ClientType clientType) {
        var client = new ClientG();
        client.setUuid(UUID.randomUUID());
        client.setActive(true);
        client.setName(LocalizedString.from(RUS, randomName()));
        client.setPhoneNumber(randomCode());
        client.setClientTypeCode(clientType.getCode());
        client.setCityCode(randomCode());

        return client;
    }
}
