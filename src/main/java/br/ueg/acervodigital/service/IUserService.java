package br.ueg.acervodigital.service;

import br.ueg.acervodigital.dto.request.UserRequestDTO;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.entities.UserLog;
import br.ueg.genericarchitecture.service.IAbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IAbstractService<UserRequestDTO, User, Long> {
    boolean isUserEnabled(Long userId);
    void toggleUserAccess(Long userId, boolean enable);
    Page<UserLog> getLogUsers(Pageable pageable);
}
