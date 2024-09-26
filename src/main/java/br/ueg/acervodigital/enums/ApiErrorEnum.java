package br.ueg.acervodigital.enums;

import lombok.Getter;

@Getter
public enum ApiErrorEnum {
    GENERAL(400, "Erro desconhecido."),
    CONFIRM_PASSWORD_NOT_ENTIRED(400, "Confirmação de senha não informada!"),
    PASSWORD_NOT_ENTIRED(400, "Senha não informada!"),
    PASSWORD_DIFERENT(400, "Ambas senhas estão diferentes!"),
    PASSWORD_INVALID(400, "Senha inválida!");

    private final Integer id;
    private final String message;

    ApiErrorEnum(Integer id, String message){
        this.id = id;
        this.message = message;
    }
}
