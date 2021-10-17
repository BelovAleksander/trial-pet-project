package ru.belov.trial.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.belov.trial.dao.configuration.MybatisTestConfiguration;
import ru.belov.trial.entity.ClientEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomCode;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomText;

@SpringBootTest(classes = MybatisTestConfiguration.class)
class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    @Test
    public void save_allFieldFilledCase_saved() {
        //given
        ClientEntity clientEntity = generateClientEntity();
        //when
        clientDao.save(clientEntity);
        //then
        fail();
    }

    @Test
    public void findByUuid_() {
        //given
        //when
        ClientEntity clientEntity = clientDao.findByUuid(UUID.randomUUID());
        //then
        assertNotNull(clientEntity);
    }

    private ClientEntity generateClientEntity() {
        return ClientEntity.builder()
                .uuid(UUID.randomUUID())
                .active(true)
                .clientTypeCode(randomCode())
                .name(randomText())
                .cityCode(randomCode())
                .phoneNumber(randomCode())
                .build();
    }
}