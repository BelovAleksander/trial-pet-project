package ru.belov.bookstore.domain.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.bookstore.application.constant.ExceptionMessage;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.port.out.PaymentMethodDao;
import ru.belov.bookstore.domain.validation.meta.Params;
import ru.belov.bookstore.domain.validation.meta.ValidationChainElement;

@Component
public class ClientValidator implements EntityValidator<Client> {

    private final ValidationChainElement<Client, Params> chainElement;

    @Autowired
    public ClientValidator(
            @Qualifier("clientPaymentMethodsExistRule") ValidationChainElement<Client, Params> chainElement) {
        this.chainElement = chainElement;
    }

    @Override
    public void checkData(Client entity, Params params) {
        chainElement.apply(entity, params);
    }
}

@Component
@RequiredArgsConstructor
class ClientPaymentMethodsExistRule implements ValidationChainElement<Client, Params> {

    private final PaymentMethodDao paymentMethodDao;

    @Override
    public void apply(Client data, Params params) {
        data.getPaymentMethodUuidList().forEach(paymentMethodUuid -> {
            if (!paymentMethodDao.exists(paymentMethodUuid)) {
                fail(ExceptionMessage.PAYMENT_METHOD_NOT_EXISTS, paymentMethodUuid.toString());
            }
        });
    }
}
