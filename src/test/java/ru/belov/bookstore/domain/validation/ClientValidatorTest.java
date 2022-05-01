package ru.belov.bookstore.domain.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.belov.bookstore.domain.entity.Client;
import ru.belov.bookstore.domain.validation.meta.Params;
import ru.belov.bookstore.domain.validation.meta.ValidationChainElement;
import ru.belov.bookstore.domain.validation.params.ClientParams;

import static org.mockito.Mockito.verify;
import static test.util.TestValuesUtil.generateClient;

@ExtendWith(SpringExtension.class)
class ClientValidatorTest {

    @MockBean
    private ValidationChainElement<Client, Params> chainElement;
    private ClientValidator clientValidator;

    @BeforeEach
    void setUp() {
        clientValidator = new ClientValidator(chainElement);
    }

    @Test
    void checkData_baseCase() {
        //given
        var client = generateClient();
        //when
        clientValidator.checkData(client, new ClientParams());
        //then
        verify(chainElement).apply(client, new ClientParams());
    }
}