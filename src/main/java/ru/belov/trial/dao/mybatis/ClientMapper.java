package ru.belov.trial.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.trial.dao.ClientDao;
import ru.belov.trial.entity.ClientEntity;

@Mapper
public interface ClientMapper extends ClientDao {

    void save(ClientEntity client);
}
