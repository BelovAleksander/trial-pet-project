package ru.belov.bookstore.infrastructure.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.belov.bookstore.domain.entity.PaymentMethod;
import ru.belov.bookstore.domain.usecase.AddPaymentMethodUseCase;
import ru.belov.bookstore.infrastructure.web.dto.PaymentMethodDto;

import javax.validation.Valid;

@Slf4j
@RequestMapping(PaymentMethodController.BASE_URI)
@RestController
@RequiredArgsConstructor
public class PaymentMethodController {

    protected static final String BASE_URI = "/web/bookstore/paymentMethod";
    private final AddPaymentMethodUseCase addPaymentMethodUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@Valid @RequestBody PaymentMethodDto dto) {
        log.debug("Request to web/bookstore/paymentMethod/add: {}", dto);
        var entity = toEntity(dto);
        addPaymentMethodUseCase.process(entity);
    }

    private PaymentMethod toEntity(PaymentMethodDto dto) {
        var entity = new PaymentMethod();
        entity.setClientUuid(dto.getClientUuid());
        entity.setBankAccount(dto.getBankAccount());
        entity.setActive(true);
        return entity;
    }
}
