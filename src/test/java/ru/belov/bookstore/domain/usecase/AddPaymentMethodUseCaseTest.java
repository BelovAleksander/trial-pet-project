package ru.belov.bookstore.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.belov.bookstore.application.exception.AlreadyExistsException;
import ru.belov.bookstore.domain.port.out.PaymentMethodDao;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static test.util.TestValuesUtil.generatePaymentMethod;

@ExtendWith(SpringExtension.class)
class AddPaymentMethodUseCaseTest {

    @MockBean
    private PaymentMethodDao paymentMethodDao;
    private AddPaymentMethodUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new AddPaymentMethodUseCase(paymentMethodDao);
    }

    @Test
    void process_whenNotExist_thenSaved() {
        //given
        var paymentMethod = generatePaymentMethod(UUID.randomUUID());
        when(paymentMethodDao.exists(paymentMethod)).thenReturn(false);
        //when
        useCase.process(paymentMethod);
        //then
        verify(paymentMethodDao).save(paymentMethod);
    }

    @Test
    void process_whenExist_thenExceptionThrown() {
        //given
        var paymentMethod = generatePaymentMethod(UUID.randomUUID());
        when(paymentMethodDao.exists(paymentMethod)).thenReturn(true);
        //when-then
        assertThrows(AlreadyExistsException.class, () -> useCase.process(paymentMethod));
    }
}