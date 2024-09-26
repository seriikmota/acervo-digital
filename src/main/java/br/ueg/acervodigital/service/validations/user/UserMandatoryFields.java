package br.ueg.acervodigital.service.validations.user;

import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigitalarquitetura.enums.ValidationActionsEnum;
import br.ueg.acervodigitalarquitetura.exception.BusinessLogicException;
import br.ueg.acervodigitalarquitetura.validation.IValidations;
import org.springframework.stereotype.Component;

@Component
public class UserMandatoryFields implements IValidations<User> {
    @Override
    public void validate(User data, ValidationActionsEnum action) {
        if (data.getName() == null) {
            throw new BusinessLogicException("O nome do usuário é obrigatório!");
        }
        if (data.getEmail() == null) {
            throw new BusinessLogicException("O email do usuário é obrigatório!");
        }
    }
}
