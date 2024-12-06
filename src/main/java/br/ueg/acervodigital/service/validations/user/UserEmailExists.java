package br.ueg.acervodigital.service.validations.user;

import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.enums.ErrorEnum;
import br.ueg.acervodigital.repository.UserRepository;
import br.ueg.genericarchitecture.enums.ValidationActionsEnum;
import br.ueg.genericarchitecture.exception.Message;
import br.ueg.genericarchitecture.validation.IValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEmailExists implements IValidations<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public void validate(User data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE)) {
            if (data.getEmail() != null && !data.getEmail().isEmpty()) {
                if (repository.existsByEmail(data.getEmail()))
                    messagesToThrow.add(new Message(ErrorEnum.EMAIL_EXISTS));
            }
        }
    }
}
