package ru.belov.bookstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.belov.bookstore.application.constant.ClientType;
import ru.belov.bookstore.dao.configuration.MybatisTestConfiguration;
import ru.belov.bookstore.dao.configuration.TestCaseConfiguration;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.entity.LocalizedString;
import ru.belov.bookstore.domain.port.out.ClientDao;

import java.util.UUID;

import static ru.belov.bookstore.application.constant.Language.RUS;
import static test.util.TestValuesUtil.randomCode;
import static test.util.TestValuesUtil.randomName;

//for presentation
@Transactional
@SpringBootTest(classes = { MybatisTestConfiguration.class, TestCaseConfiguration.class })
class ClientDaoTest {

    @Autowired
    ClientDao clientDao;

    private Client generateClientEntity() {
        return Client.builder()
                .uuid(UUID.randomUUID())
                .name(LocalizedString.from(RUS, randomName()))
                .phoneNumber(randomCode())
                .clientTypeCode(ClientType.UR.getCode())
                .cityCode(randomCode())
                .build();
    }
}