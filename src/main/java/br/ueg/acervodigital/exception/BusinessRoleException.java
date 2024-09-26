package br.ueg.acervodigital.exception;

import br.ueg.acervodigital.enums.ApiErrorEnum;
import lombok.Getter;

@Getter
public class BusinessRoleException extends RuntimeException {
    private final ApiErrorEnum error;

    public BusinessRoleException(String message){
        super(message);
        this.error = ApiErrorEnum.GENERAL;
    }
    public BusinessRoleException(ApiErrorEnum err){
        super(err.getMessage());
        this.error = err;
    }
}
