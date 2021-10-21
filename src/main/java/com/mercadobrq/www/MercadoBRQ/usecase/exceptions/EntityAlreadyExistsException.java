package com.mercadobrq.www.MercadoBRQ.usecase.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(String menssagem) {
        super(menssagem);
    }
}
