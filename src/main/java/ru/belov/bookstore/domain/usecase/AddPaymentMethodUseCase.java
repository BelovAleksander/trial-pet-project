package ru.belov.bookstore.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.belov.bookstore.application.exception.AlreadyExistsException;
import ru.belov.bookstore.domain.entity.PaymentMethod;
import ru.belov.bookstore.domain.port.out.PaymentMethodDao;

import javax.annotation.Nonnull;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddPaymentMethodUseCase {

    private final PaymentMethodDao paymentMethodDao;

    public void process(@Nonnull PaymentMethod paymentMethod) {
        if (paymentMethodDao.exists(paymentMethod)) {
            throw new AlreadyExistsException(paymentMethod);
        }
        paymentMethod.setUuid(UUID.randomUUID());
        paymentMethodDao.save(paymentMethod);
    }
}
