package ru.belov.trial.dto;

import ru.belov.trial.constant.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Map;

@Schema
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalizedStringDto extends CommonDto {

    private Map<Language, String> localityMap;

}
