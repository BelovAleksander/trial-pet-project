package ru.belov.trial.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.belov.trial.constant.ClientType;
import ru.belov.trial.dao.configuration.MybatisTestConfiguration;
import ru.belov.trial.dao.configuration.TestCaseConfiguration;
import ru.belov.trial.entity.ClientEntity;
import ru.belov.trial.infrastructure.LocalizedString;
import test.TestCaseHelper;
import test.mapper.ClientGMapper;
import test.model.ClientG;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.belov.trial.constant.Language.RUS;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomCode;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomText;

@Transactional
@SpringBootTest(classes = {MybatisTestConfiguration.class, TestCaseConfiguration.class})
class ClientDaoTest {
    private static final String CITY_CODE = randomCode();

    @Autowired
    ClientDao clientDao;
    @Autowired
    ClientGMapper clientGMapper;
    @Autowired
    TestCaseHelper testCaseHelper;

    @Test
    public void save_fullObjectSave_allFieldSaved() {
        //given
        var city = testCaseHelper.createCity();
        city.setCode(CITY_CODE);
        testCaseHelper.completeTestCase();

        var clientEntity = generateClientEntity();
        //when
        clientDao.save(clientEntity);
        //then
        var result = clientGMapper.selectByPrimaryKey(clientEntity.getUuid()).orElse(new ClientG());

        assertEquals(clientEntity.getUuid(), result.getUuid());
        assertEquals(clientEntity.getName(), result.getName());
    }

    @Test
    public void findByUuid_1RowInTable_1RowWithSameFieldsFoundByUuid() {
        //given
        var city = testCaseHelper.createCity();
        var client = testCaseHelper.createClient(city, ClientType.UR);
        testCaseHelper.completeTestCase();
        //when
        var result = clientDao.findByUuid(client.getUuid());
        //then
        assertEquals(client.getUuid(), result.getUuid());
        assertEquals(client.getName(), result.getName());
    }

    private ClientEntity generateClientEntity() {
        return ClientEntity.builder()
                .uuid(UUID.randomUUID())
                .name(LocalizedString.from(RUS, randomText()))
                .phoneNumber(randomCode())
                .clientTypeCode(ClientType.UR.getCode())
                .cityCode(CITY_CODE)
                .build();
    }
}