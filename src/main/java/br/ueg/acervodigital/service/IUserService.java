package br.ueg.acervodigital.service;

import br.ueg.acervodigital.entities.UserLog;

import java.util.List;

public interface IUserService {
    boolean isUserEnabled(Long userId);
    void toggleUserAccess(Long userId, boolean enable);
    List<UserLog> getLogUsers();
}
