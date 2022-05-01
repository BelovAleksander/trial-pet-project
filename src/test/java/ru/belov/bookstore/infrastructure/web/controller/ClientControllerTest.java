package ru.belov.bookstore.infrastructure.web.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.belov.bookstore.domain.usecase.SaveClientUseCase;
import ru.belov.bookstore.infrastructure.web.converter.ClientDtoConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static test.util.TestValuesUtil.generateClient;
import static test.util.TestValuesUtil.generateClientSaveRequestDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClientController.class)
class ClientControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ClientDtoConverter converter;
    @MockBean
    private SaveClientUseCase saveClientUseCase;

    @Test
    void save_whenValidDto_thenUseCaseProcessed() throws Exception {
        //given
        var clientDto = generateClientSaveRequestDto();
        var client = generateClient();
        when(converter.toEntity(clientDto)).thenReturn(client);
        //when
        var result = mvc.perform(MockMvcRequestBuilders
                .post(ClientController.BASE_URI + "/save")
                .content(asJsonString(clientDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        //then
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
        verify(saveClientUseCase).process(client);
    }

    @Test
    void save_whenInvalidDto_thenUseCaseProcessed() throws Exception {
        //given
        var clientDto = generateClientSaveRequestDto();
        clientDto.setPhoneNumber("");
        //when
        var result = mvc.perform(MockMvcRequestBuilders
                .post(ClientController.BASE_URI + "/save")
                .content(asJsonString(clientDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        //then
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
        verifyNoInteractions(saveClientUseCase);
    }
}