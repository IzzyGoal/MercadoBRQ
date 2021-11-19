package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class EmptyOff extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyOff(String menssagem) {
        super(menssagem);
    }
}
