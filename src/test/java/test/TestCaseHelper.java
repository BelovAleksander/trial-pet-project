package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.infrastructure.LocalizedString;
import test.mapper.CityGMapper;
import test.mapper.ClientGMapper;
import test.model.CityG;
import test.model.ClientG;

import java.util.*;
import java.util.function.Supplier;

import static ru.belov.trial.constant.Language.RUS;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomCode;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomText;

@Component
public class TestCaseHelper {

    private final Map<Class, List<Supplier<Integer>>> insertQueriesCallMap = new HashMap<>();
    private final List<Class> insertionOrder = Arrays.asList(
            CityG.class, ClientG.class
    );

    @Autowired
    CityGMapper cityGMapper;
    @Autowired
    ClientGMapper clientGMapper;

    public CityG createCity() {
        CityG city = new CityG();
        city.setCode(randomCode());
        city.setName(LocalizedString.from(RUS, randomText()));

        putEntity(city, () -> cityGMapper.insert(city));
        return city;
    }

    public ClientG createClient(CityG city, ClientType clientType) {
        ClientG client = new ClientG();
        client.setUuid(UUID.randomUUID());
        client.setCityCode(city.getCode());
        client.setClientTypeCode(clientType.getCode());
        client.setActive(true);
        client.setName(LocalizedString.from(RUS, randomText()));
        client.setPhoneNumber(randomCode());

        putEntity(client, () -> clientGMapper.insert(client));
        return client;
    }

    public void completeTestCase() {
        var entryList = new ArrayList<>(insertQueriesCallMap.entrySet());
        entryList.sort(Comparator.comparingInt(entry -> insertionOrder.indexOf(entry.getKey())));

        entryList.forEach(entry -> entry.getValue().forEach(Supplier::get));
    }

    private void putEntity(Object entity, Supplier<Integer> supplier) {
        insertQueriesCallMap.computeIfAbsent(entity.getClass(), list -> new ArrayList<>())
                .add(supplier);
    }
}
