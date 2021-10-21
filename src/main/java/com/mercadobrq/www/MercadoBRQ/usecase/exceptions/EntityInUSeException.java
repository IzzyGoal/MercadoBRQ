package com.mercadobrq.www.MercadoBRQ.usecase.exceptions;

public class EntityInUSeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityInUSeException(String menssagem) {
        super(menssagem);
    }
}
