package ru.belov.trial.service.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.belov.trial.entity.ClientEntity;
import ru.belov.trial.service.validation.meta.Params;
import ru.belov.trial.service.validation.meta.ValidationChainElement;

@Component
@RequiredArgsConstructor
public class ClientValidator implements EntityValidator<ClientEntity> {

    private final ValidationChainElement<ClientEntity, Params> clientUuidNotNull;

    @Override
    public void checkData(ClientEntity entity, Params params) {
        clientUuidNotNull.apply(entity, params);
    }
}

@Component
class ClientUuidNotNull implements ValidationChainElement<ClientEntity, Params> {

    @Override
    public void apply(ClientEntity data, Params params) {
        //some business-logic validations
    }
}
