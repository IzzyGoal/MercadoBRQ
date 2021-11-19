package com.mercadobrq.www.mercadobrq.entrypoint.controller.exceptions;

import com.mercadobrq.www.mercadobrq.usecase.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(EmptyOff.class)
    public final ResponseEntity<?> handlerEmptyOff(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        MensagemExceptionModelResponse message = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(message);
    }


    @ExceptionHandler(EntityAlreadyExistsException.class)
    public final ResponseEntity<?> handlerEntityAlreadyPresent(Exception ex) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        MensagemExceptionModelResponse mensagemExceptionModelResponse = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }
    
    @ExceptionHandler(BadBusyException.class)
    public final ResponseEntity<?> handlerExceptionBadBusy(Exception ex) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        MensagemExceptionModelResponse mensagemExceptionModelResponse =  exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }

    @ExceptionHandler(EntityInUseException.class)
    public final ResponseEntity<?> handlerEntityInUse(Exception ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;

        MensagemExceptionModelResponse mensagemExceptionModelResponse = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        status = HttpStatus.BAD_REQUEST;
        MensagemExceptionModelResponse message = exceptionAnswerField(status,ex,bindingResult);

        return handleExceptionInternal(ex, message, headers, status, request);
    }

    @ExceptionHandler(ProductBlankException.class)
    private final ResponseEntity<?> handlerProductIsBlankOrNullException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;

        MensagemExceptionModelResponse mensagemExceptionModelResponse = exceptionAnswer(httpStatus,ex);

        return ResponseEntity.status(httpStatus).body(mensagemExceptionModelResponse);
    }

    @ExceptionHandler(BadResquestPostException.class)
    private final ResponseEntity<?> handleCategoryNotExist(Exception ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

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

    private MensagemExceptionModelResponse exceptionAnswerField(HttpStatus httpStatus, MethodArgumentNotValidException ex, BindingResult bindingResult) {

        List<FieldsAnswers> fieldsAnswersList = bindingResult.getFieldErrors().stream()
                .map(fieldError -> FieldsAnswers.builder()
                        .name(fieldError.getField())
                        .messageUser(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        return MensagemExceptionModelResponse.builder()
                .code(String.valueOf(httpStatus))
                .menssage("A informação fornecida nao pode ser aceita pois nao esta dentro do padrão ,por favor ,tente novamente.")
                .fieldsList(fieldsAnswersList)
                .build();
    }
}
