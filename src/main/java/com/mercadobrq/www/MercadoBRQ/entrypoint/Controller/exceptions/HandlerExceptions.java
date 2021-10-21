package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.exceptions;

import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityAlreadyExistsException;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(EntityNotFound.class)
    public final ResponseEntity<?> handlerEntityNotFound(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        MensagemExceptionModelResponse menssage = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(menssage);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public final ResponseEntity<?> handlerEntityAlreadyPresent(Exception ex) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        MensagemExceptionModelResponse mensagemExceptionModelResponse = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }

    private MensagemExceptionModelResponse exceptionAnswer(HttpStatus httpStatus, Exception ex) {
        return MensagemExceptionModelResponse.builder()
                .code(String.valueOf(httpStatus.value()))
                .menssage(ex.getMessage())
                .build();
    }
}
