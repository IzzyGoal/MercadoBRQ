package com.mercadobrq.www.mercadobrq.usecase.exceptions;

public class EntityNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityNotFound(String menssage) {
        super (menssage);
    }
}
