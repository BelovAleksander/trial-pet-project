package ru.belov.trial.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.trial.entity.PaymentMethod;

import java.util.UUID;

@Mapper
public interface PaymentMethodMapper {

    void save(PaymentMethod client);

    void inactive(UUID uuid);
}
