package ru.belov.bookstore.domain.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.belov.bookstore.application.exception.ValidationException;
import ru.belov.bookstore.domain.port.out.PaymentMethodDao;
import ru.belov.bookstore.domain.validation.params.ClientParams;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static test.util.TestValuesUtil.generateClient;

@ExtendWith(SpringExtension.class)
class ClientPaymentMethodsExistRuleTest {

    @MockBean
    private PaymentMethodDao paymentMethodDao;
    private ClientPaymentMethodsExistRule rule;

    @BeforeEach
    void setUp() {
        rule = new ClientPaymentMethodsExistRule(paymentMethodDao);
    }

    @Test
    void apply_whenNoPaymentMethods_thenOk() {
        //given
        var client = generateClient();
        client.setPaymentMethodUuidList(emptyList());
        var params = new ClientParams();
        //when-then
        assertDoesNotThrow(() -> rule.apply(client, params));
    }

    @Test
    void apply_whenPaymentMethodExists_thenOk() {
        //given
        var client = generateClient();
        var paymentMethodUuid = UUID.randomUUID();
        client.setPaymentMethodUuidList(List.of(paymentMethodUuid));
        var params = new ClientParams();

        when(paymentMethodDao.exists(paymentMethodUuid)).thenReturn(true);
        //when-then
        assertDoesNotThrow(() -> rule.apply(client, params));
    }

    @Test
    void apply_whenPaymentMethodNotExists_thenExceptionThrown() {
        //given
        var client = generateClient();
        var paymentMethodUuid = UUID.randomUUID();
        client.setPaymentMethodUuidList(List.of(paymentMethodUuid));
        var params = new ClientParams();

        when(paymentMethodDao.exists(paymentMethodUuid)).thenReturn(false);
        //when-then
        assertThrows(ValidationException.class, () -> rule.apply(client, params));
    }
}