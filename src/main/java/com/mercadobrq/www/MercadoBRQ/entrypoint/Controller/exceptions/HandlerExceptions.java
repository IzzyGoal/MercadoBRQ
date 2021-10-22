package com.mercadobrq.www.MercadoBRQ.entrypoint.Controller.exceptions;

import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityAlreadyExistsException;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityInUseException;
import com.mercadobrq.www.MercadoBRQ.usecase.exceptions.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Classe responsavel por tratar e personalizar exceções.
 * @author Gabriel Silva Lima
 * @since 18/10/2021.
 */
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

    @ExceptionHandler(EntityInUseException.class)
    public final ResponseEntity<?> handlerEntityInUse(Exception ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        MensagemExceptionModelResponse mensagemExceptionModelResponse = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }

    /**
     * metodo responsavel por gerar um modelo de resposta as exceções.
     * @param httpStatus {@code HttpStatus} - Classe mae com todas os codigos de exceções
     * @param ex {@code Exception} -
     * @return Retorna um Builde com o corpo de resposta.
     */
    private MensagemExceptionModelResponse exceptionAnswer(HttpStatus httpStatus, Exception ex) {
        return MensagemExceptionModelResponse.builder()
                .code(String.valueOf(httpStatus.value()))
                .menssage(ex.getMessage())
                .build();
    }
}
