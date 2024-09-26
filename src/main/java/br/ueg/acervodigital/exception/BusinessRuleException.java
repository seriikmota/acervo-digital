package br.ueg.acervodigital.exception;

import br.ueg.acervodigital.enums.ApiErrorEnum;
import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException {
    private final ApiErrorEnum error;

    public BusinessRuleException(String message){
        super(message);
        this.error = ApiErrorEnum.GENERAL;
    }
    public BusinessRuleException(ApiErrorEnum err){
        super(err.getMessage());
        this.error = err;
    }
}
