package br.ueg.acervodigital.service.impl;

import br.ueg.acervodigital.entities.Role;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.entities.UserGroup;
import br.ueg.acervodigital.entities.UserLog;
import br.ueg.acervodigital.repository.UserGroupRepository;
import br.ueg.acervodigital.repository.UserLogRepository;
import br.ueg.acervodigital.repository.UserRepository;
import br.ueg.genericarchitecture.dto.CredentialDTO;
import br.ueg.genericarchitecture.enums.ApiErrorEnum;
import br.ueg.genericarchitecture.exception.BusinessException;
import br.ueg.genericarchitecture.service.IUserProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserProviderService implements IUserProviderService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    private CredentialDTO getCredential(User user) {
        List<String> roles = this.getRolesOfUserGroup(user.getUserGroup().getId());

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
        if (user == null) throw new BusinessException(ApiErrorEnum.LOGIN_INVALID);
        return getCredential(user);
    }

    @Override
    public CredentialDTO getCredentialByEmail(String email) {
        User user = repository.findByEmail(email);
        if (user == null) throw new BusinessException(ApiErrorEnum.LOGIN_INVALID);
        return getCredential(user);
    }

    private List<String> getRolesOfUserGroup(Long groupUserId) {
        UserGroup userGroup = userGroupRepository.findById(groupUserId).orElse(null);
        List<String> roles = new ArrayList<>();
        if (userGroup != null && userGroup.getRoles() != null) {
            for (Role userGroupRole : userGroup.getRoles()) {
                roles.add(userGroupRole.getRole());
            }
        }
        return roles;
    }

    @Override
    public void recordLog(CredentialDTO credentialDTO, String action) {
        UserLog log = UserLog.builder()
                .login(credentialDTO.getLogin())
                .name(credentialDTO.getName())
                .date(LocalDateTime.now())
                .action(action).build();
        userLogRepository.save(log);
    }
}
