package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class BadResquestPostException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BadResquestPostException(String menssagem) {
        super(menssagem);
    }
}
