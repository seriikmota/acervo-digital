package br.ueg.acervodigital.controller.impl;

import br.ueg.acervodigital.exception.BusinessRoleException;
import br.ueg.acervodigitalarquitetura.exception.BusinessLogicException;
import br.ueg.acervodigitalarquitetura.exception.DataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomHandlerException {
    @ExceptionHandler(DataException.class)
    public ResponseEntity<String> handleDataException(DataException ex){
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<String> handleBusinessLogicException(BusinessLogicException ex) {
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessRoleException.class)
    public ResponseEntity<String> handleBusinessRoleException(BusinessRoleException ex) {
        return ResponseEntity.status(ex.getError().getId()).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.badRequest().body("Ocorreu um erro ao realizar a requisição!");
    }
}
