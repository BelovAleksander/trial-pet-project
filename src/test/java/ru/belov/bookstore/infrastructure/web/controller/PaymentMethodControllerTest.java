package ru.belov.bookstore.infrastructure.web.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.belov.bookstore.domain.entity.PaymentMethod;
import ru.belov.bookstore.domain.usecase.AddPaymentMethodUseCase;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static test.util.TestValuesUtil.generatePaymentMethodDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentMethodController.class)
class PaymentMethodControllerTest extends BaseControllerTest {

    @MockBean
    private AddPaymentMethodUseCase addPaymentMethodUseCase;
    @Captor
    private ArgumentCaptor<PaymentMethod> paymentMethodCaptor;
    @Autowired
    private MockMvc mvc;

    @Test
    void add_baseCase() throws Exception {
        //given
        var paymentMethodDto = generatePaymentMethodDto(UUID.randomUUID());
        //when
        var result = mvc.perform(MockMvcRequestBuilders
                        .put(PaymentMethodController.BASE_URI + "/add")
                        .content(asJsonString(paymentMethodDto))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn();
        //then
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        verify(addPaymentMethodUseCase).process(paymentMethodCaptor.capture());
        var entity = paymentMethodCaptor.getValue();

        assertNull(entity.getUuid());
        assertTrue(entity.isActive());
        assertEquals(paymentMethodDto.getBankAccount(), entity.getBankAccount());
        assertEquals(paymentMethodDto.getClientUuid(), entity.getClientUuid());
    }
}