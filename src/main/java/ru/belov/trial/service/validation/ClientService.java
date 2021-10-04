package ru.belov.trial.service.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belov.trial.dao.ClientDao;
import ru.belov.trial.entity.ClientEntity;
import ru.belov.trial.service.esb.EsbSender;
import ru.belov.trial.service.validation.params.ClientParams;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientValidator validator;
    private final ClientDao clientDao;
    private final EsbSender esbSender;

    @Transactional
    public void save(ClientEntity client) {
        validator.checkData(client, new ClientParams());
        client.setUuid(UUID.randomUUID());
        clientDao.save(client);
        esbSender.send(client);
    }
}
