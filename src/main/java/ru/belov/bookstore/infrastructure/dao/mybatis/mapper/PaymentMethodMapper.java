package ru.belov.bookstore.infrastructure.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import ru.belov.bookstore.domain.entity.PaymentMethod;
import ru.belov.bookstore.domain.port.out.PaymentMethodDao;

import java.util.UUID;

@Mapper
public interface PaymentMethodMapper extends PaymentMethodDao {

    void save(PaymentMethod paymentMethod);

    boolean exists(PaymentMethod paymentMethod);

    void inactive(UUID uuid);
}
