package ru.belov.bookstore.domain.port.out;

import ru.belov.bookstore.domain.entity.Client;

import java.util.UUID;

public interface ClientDao {

    void save(Client client);

    Client findByUuid(UUID clientUuid);
}
