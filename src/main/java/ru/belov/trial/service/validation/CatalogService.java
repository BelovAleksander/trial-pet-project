package ru.belov.trial.service.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belov.trial.dao.CatalogDao;
import ru.belov.trial.dao.ClientDao;
import ru.belov.trial.dto.CatalogRequestDto;
import ru.belov.trial.dto.CatalogResponseDto;
import ru.belov.trial.entity.ClientEntity;
import ru.belov.trial.service.esb.EsbSender;
import ru.belov.trial.service.validation.params.ClientParams;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogDao catalogDao;

    public List<CatalogResponseDto> getValues(CatalogRequestDto requestDto) {
        return catalogDao.getValues(requestDto);
    }
}
