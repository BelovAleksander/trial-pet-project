package ru.belov.bookstore.infrastructure.web.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.belov.bookstore.application.constant.Language;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.util.TestValuesUtil.generateClientSaveRequestDto;

@ExtendWith(SpringExtension.class)
class ClientDtoConverterTest {

    private final ClientDtoConverter converter = new ClientDtoConverter();

    @Test
    void toEntity_baseCase() {
        //given
        var dto = generateClientSaveRequestDto();
        //when
        var result = converter.toEntity(dto);
        //then
        assertEquals(dto.getClientType().getCode(), result.getClientTypeCode());
        assertEquals(dto.getCityCode(), result.getCityCode());
        assertEquals(dto.getRusName(), result.getName().get(Language.RUS));
        assertEquals(dto.getEngName(), result.getName().get(Language.ENG));
        assertEquals(dto.getActive(), result.isActive());
        assertEquals(dto.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(dto.getPaymentMethodUuidList(), result.getPaymentMethodUuidList());
    }
}