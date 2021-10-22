package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class BadBusyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BadBusyException(String menssagem) {
        super(menssagem);
    }
}
