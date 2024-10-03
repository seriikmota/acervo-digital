package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.repository.UserRepository;
import br.ueg.acervodigitalarquitetura.dto.CredentialDTO;
import br.ueg.acervodigitalarquitetura.enums.ErrorEnum;
import br.ueg.acervodigitalarquitetura.exception.BusinessLogicException;
import br.ueg.acervodigitalarquitetura.service.IUserProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserProviderService implements IUserProviderService {

    @Autowired
    private UserRepository repository;

    private CredentialDTO getCredential(User user) {
        List<String> roles = new ArrayList<>();
        if (user.getFunction().equals("Admin")) {
            roles.addAll(getRolesOfAdmin());
        } else if (user.getFunction().equals("Assistant")) {
            roles.addAll(getRolesOfAssistant());
        }
        return CredentialDTO.builder()
                .login(user.getLogin())
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .roles(roles)
                .activeState(true)
                .password(user.getPassword())
                .build();
    }

    @Override
    public CredentialDTO getCredentialByLogin(String login) {
        User user = repository.findByLogin(login);
        if (user == null) throw new BusinessLogicException(ErrorEnum.LOGIN_INVALID);
        return getCredential(user);
    }

    @Override
    public CredentialDTO getCredentialByEmail(String email) {
        User user = repository.findByEmail(email);
        if (user == null) throw new BusinessLogicException(ErrorEnum.LOGIN_INVALID);
        return getCredential(user);
    }

    private List<String> getRolesOfAdmin() {
        return Arrays.asList(
                "ROLE_USER_CREATE",
                "ROLE_USER_READ",
                "ROLE_USER_UPDATE",
                "ROLE_USER_DELETE",
                "ROLE_USER_LISTALL",
                "ROLE_ITEM_CREATE",
                "ROLE_ITEM_READ",
                "ROLE_ITEM_UPDATE",
                "ROLE_ITEM_DELETE",
                "ROLE_ITEM_LISTALL"
        );
    }

    private List<String> getRolesOfAssistant() {
        return Arrays.asList(
                "ROLE_USER_CREATE",
                "ROLE_USER_READ",
                "ROLE_USER_UPDATE",
                "ROLE_USER_DELETE",
                "ROLE_ITEM_CREATE",
                "ROLE_ITEM_READ",
                "ROLE_ITEM_UPDATE",
                "ROLE_ITEM_DELETE"
        );
    }
}
