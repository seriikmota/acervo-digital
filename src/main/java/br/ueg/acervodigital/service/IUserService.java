package br.ueg.acervodigital.service;

public interface IUserService {
    boolean isUserEnabled(Long userId);
    void toggleUserAccess(Long userId, boolean enable);
}
