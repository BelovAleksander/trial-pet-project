package ru.belov.bookstore.infrastructure.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.port.out.ClientDao;

import java.util.UUID;

@Mapper
public interface ClientMapper extends ClientDao {

    void save(Client client);

    Client findByUuid(UUID clientUuid);
}
