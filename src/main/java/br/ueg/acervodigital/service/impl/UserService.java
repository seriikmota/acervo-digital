package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.mapper.UserMapper;
import br.ueg.acervodigital.repository.UserRepository;
import br.ueg.acervodigital.service.IUserService;
import br.ueg.acervodigitalarquitetura.enums.ErrorEnum;
import br.ueg.acervodigitalarquitetura.exception.BusinessLogicException;
import br.ueg.acervodigitalarquitetura.service.impl.AbstractCrudService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<UserRequestDTO, UserResponseDTO, UserListDTO, User, UserRepository, UserMapper, Long>
        implements IUserService {

    @Override
    protected void prepareToCreate(User data) {
        data.setPassword(encryptPassword(data.getPassword()));
    }

    @Override
    protected void prepareToUpdate(User dataDB) {

    }

    @Override
    protected void prepareToDelete(User dataDB) {

    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    protected void validatePassword(UserRequestDTO dtoCreate) {
        if (dtoCreate.getPassword() == null)
            throw new BusinessLogicException(ErrorEnum.PASSWORD_NOT_ENTIRED);
        if (dtoCreate.getConfirmPassword() == null)
            throw new BusinessLogicException(ErrorEnum.CONFIRM_PASSWORD_NOT_ENTIRED);
        if (!dtoCreate.getPassword().equals(dtoCreate.getConfirmPassword()))
            throw new BusinessLogicException(ErrorEnum.PASSWORD_DIFERENT);
        if (dtoCreate.getPassword().trim().length() < 8)
            throw new BusinessLogicException(ErrorEnum.PASSWORD_INVALID);
    }
}
