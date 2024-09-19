package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.dto.list.UserListDTO;
import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.dto.response.UserResponseDTO;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.mapper.UserMapper;
import br.ueg.acervodigital.repository.UserRepository;
import br.ueg.acervodigital.service.IUserService;
import br.ueg.acervodigitalarquitetura.service.impl.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<UserRequestDTO, UserResponseDTO, UserListDTO, User, UserRepository, UserMapper, Long>
        implements IUserService {

    @Override
    protected void prepareToCreate(User data) {

    }

    @Override
    protected void prepareToUpdate(User dataDB) {

    }

    @Override
    protected void prepareToDelete(User dataDB) {

    }
}
