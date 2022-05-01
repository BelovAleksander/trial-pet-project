package ru.belov.bookstore.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.port.out.ClientDao;
import ru.belov.bookstore.domain.validation.ClientValidator;
import ru.belov.bookstore.domain.validation.params.ClientParams;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveClientUseCase {

    private final ClientValidator validator;
    private final ClientDao clientDao;

    @Transactional
    public void process(Client client) {
        validator.checkData(client, new ClientParams());
        client.setUuid(UUID.randomUUID());
        clientDao.save(client);
    }
}
