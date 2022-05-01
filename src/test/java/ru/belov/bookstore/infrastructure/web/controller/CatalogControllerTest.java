package ru.belov.bookstore.infrastructure.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
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
import ru.belov.bookstore.domain.port.out.CatalogDao;
import ru.belov.bookstore.infrastructure.web.dto.CatalogRequestDto;
import ru.belov.bookstore.infrastructure.web.dto.CatalogResponseDto;
import ru.belov.bookstore.infrastructure.web.dto.CollectionWrapperResponseDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static test.util.TestValuesUtil.generateCatalogResponseDto;
import static test.util.TestValuesUtil.randomCode;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CatalogController.class)
class CatalogControllerTest extends BaseControllerTest {

    @MockBean
    private CatalogDao catalogDao;
    @Autowired
    private MockMvc mvc;

    @Test
    void getValues_baseCase() throws Exception {
        //given
        var dto = new CatalogRequestDto();
        dto.setCatalogName(randomCode());

        var expectedCatalogs = List.of(generateCatalogResponseDto());
        when(catalogDao.getValues(dto)).thenReturn(expectedCatalogs);
        //when
        var result = mvc.perform(MockMvcRequestBuilders
                .get(CatalogController.BASE_URI + "/getValues")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dto))
        ).andReturn();
        //then
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        var resultBody = result.getResponse().getContentAsString();
        assertNotNull(resultBody);

        var catalogs = fromJsonString(
                resultBody, new TypeReference<CollectionWrapperResponseDto<CatalogResponseDto>>() {
                }).getItems();
        assertEquals(expectedCatalogs, catalogs);
    }
}