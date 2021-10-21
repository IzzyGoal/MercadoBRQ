package com.mercadobrq.www.MercadoBRQ.usecase.exceptions;

public class ProductNotExistException extends EntityNotFound{

    private static final long serialVersionUID= 1L;

    public ProductNotExistException(String menssage) {
        super(menssage);
    }
}
