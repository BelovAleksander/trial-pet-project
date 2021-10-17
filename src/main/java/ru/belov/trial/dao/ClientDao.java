package ru.belov.trial.dao;

import ru.belov.trial.entity.ClientEntity;

import java.util.List;
import java.util.UUID;

public interface ClientDao {

    void save(ClientEntity clientEntity);

    ClientEntity findByUuid(UUID clientUuid);
}
