package ru.belov.trial.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.trial.dao.ClientDao;
import ru.belov.trial.entity.ClientEntity;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ClientMapper extends ClientDao {

    void save(ClientEntity client);

    ClientEntity findByUuid(UUID clientUuid);
}
