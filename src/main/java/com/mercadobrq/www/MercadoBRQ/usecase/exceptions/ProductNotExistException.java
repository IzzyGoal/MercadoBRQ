package com.mercadobrq.www.MercadoBRQ.usecase.Exceptions;

public class ProductNotExistException extends RuntimeException{

    private static final long serialVersionUID= 1L;

    public ProductNotExistException(String menssage) {
        super(menssage);
    }
}
