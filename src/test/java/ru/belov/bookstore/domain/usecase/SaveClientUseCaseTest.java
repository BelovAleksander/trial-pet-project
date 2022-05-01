package ru.belov.bookstore.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.belov.bookstore.application.exception.ValidationException;
import ru.belov.bookstore.domain.port.out.ClientDao;
import ru.belov.bookstore.domain.validation.ClientValidator;
import ru.belov.bookstore.domain.validation.params.ClientParams;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static test.util.TestValuesUtil.generateClient;

@ExtendWith(SpringExtension.class)
class SaveClientUseCaseTest {

    @MockBean
    private ClientValidator validator;
    @MockBean
    private ClientDao clientDao;
    private SaveClientUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new SaveClientUseCase(validator, clientDao);
    }

    @Test
    void process_baseCase() {
        //given
        var client = generateClient();
        //when
        useCase.process(client);
        //then
        verify(validator).checkData(client, new ClientParams());
        verify(clientDao).save(client);
    }

    @Test
    void process_whenValidatorThrowsException_thenClientNotSaved() {
        //given
        var client = generateClient();
        doThrow(ValidationException.class).when(validator).checkData(client, new ClientParams());
        //when
        assertThrows(ValidationException.class, () -> useCase.process(client));
        //then
        verifyNoInteractions(clientDao);
    }
}