package test.infrastructure;

import org.springframework.stereotype.Component;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.infrastructure.LocalizedString;
import test.model.ClientG;

import java.util.UUID;

import static ru.belov.trial.constant.Language.RUS;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomCode;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomText;

/**
 * Создание и насыщение моделей дефолтными значениями
 */
@Component
public class DefaultEntityHelper {

    public ClientG createClient(ClientType clientType) {
        var client = new ClientG();
        client.setUuid(UUID.randomUUID());
        client.setActive(true);
        client.setName(LocalizedString.from(RUS, randomText()));
        client.setPhoneNumber(randomText());
        client.setClientTypeCode(clientType.getCode());
        client.setCityCode(randomCode());

        return client;
    }
}
