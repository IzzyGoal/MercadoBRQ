package com.mercadobrq.www.MercadoBRQ.usecase.exceptions;

public class CategoryNotFoundException extends EntityNotFound{

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String menssagem) {
        super(menssagem);
    }
}
