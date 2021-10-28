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
import test.infrastructure.TestCaseHelper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.belov.trial.constant.Language.RUS;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomCode;
import static ru.belov.trial.dao.util.CommonValuesUtil.randomText;

@Transactional
@SpringBootTest(classes = { MybatisTestConfiguration.class, TestCaseConfiguration.class })
class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    private ClientEntity generateClientEntity() {
        return ClientEntity.builder()
                .uuid(UUID.randomUUID())
                .name(LocalizedString.from(RUS, randomText()))
                .phoneNumber(randomCode())
                .clientTypeCode(ClientType.UR.getCode())
                .cityCode(randomCode())
                .build();
    }
}