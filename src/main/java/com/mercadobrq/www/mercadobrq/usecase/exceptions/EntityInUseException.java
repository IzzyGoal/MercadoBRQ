package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class EntityInUseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityInUseException(String menssagem) {
        super(menssagem);
    }
}
