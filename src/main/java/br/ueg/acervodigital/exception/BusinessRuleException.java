package br.ueg.acervodigital.exception;

import br.ueg.acervodigital.enums.ErrorEnum;
import lombok.Getter;

@Getter
public class BusinessRuleException extends RuntimeException {
    private final ErrorEnum error;

    public BusinessRuleException(String message){
        super(message);
        this.error = ErrorEnum.GENERAL;
    }
    public BusinessRuleException(ErrorEnum err){
        super(err.getMessage());
        this.error = err;
    }
}
